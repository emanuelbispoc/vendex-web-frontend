package br.com.vendexpress.catalog.controller;

import br.com.vendexpress.catalog.dto.ProdutoRequest;
import br.com.vendexpress.catalog.services.ProdutoService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatalogoController {
    
    private final ProdutoService service;

    public CatalogoController(ProdutoService service) {
        this.service = service;
    }
    
    @GetMapping
    public String main(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        boolean isAdmin = authentication.getAuthorities().stream()
          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMINISTRADOR"));
        
        model.addAttribute("isAdmin", isAdmin);
        
        return "main_page";
    }
    
    @GetMapping("/produtos")
    public String catalogo(Model model) {
        
        model.addAttribute("produtos", service.listarTodos());
        
        return "produtos_list_page";
    }
    
    @GetMapping("/cadastrar-produto")
    public String formCadastro(Model model) {
        
        model.addAttribute("produto", new ProdutoRequest());
        
        return "form_produto";
    }
    
    @GetMapping("/produtos/{id}/atualizar")
    public String formCadastro(@PathVariable String id, Model model) {
        
        model.addAttribute("produto", service.buscarComoRequestPorId(Long.valueOf(id)));
        model.addAttribute("isEditingMode", true);
        
        return "form_produto";
    }
    
    @GetMapping("/produtos/{id}/deletar")
    public String deletarProduto(@PathVariable String id) {
        
        service.remover(Long.valueOf(id));
        
        return "redirect:/produtos";
    }
    
    @PostMapping("/cadastrar-produto")
    public String formCadastro(@Valid @ModelAttribute("produto") ProdutoRequest request, BindingResult result) {
        
        if (result.hasErrors()) {
            return "form_produto";
        }
        
        service.cadastrar(request);
        
        return "redirect:/produtos";
    }
    
    @PostMapping("/produtos/{id}/atualizar")
    public String formAtualizacao(@Valid @ModelAttribute("produto") ProdutoRequest request, BindingResult result, Model model, @PathVariable String id) {
        
        if (result.hasErrors()) {
            model.addAttribute("isEditingMode", true);
            return "form_produto";
        }
        
        service.atualizar(request);
        
        return "redirect:/produtos";
    }
}
