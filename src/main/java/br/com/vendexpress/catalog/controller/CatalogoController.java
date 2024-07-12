package br.com.vendexpress.catalog.controller;

import br.com.vendexpress.catalog.dto.ProdutoRequest;
import jakarta.validation.Valid;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatalogoController {
    
    @GetMapping
    public String main() {
        return "main_page";
    }
    
    @GetMapping("/produtos")
    public String catalogo(Model model) {
        
        model.addAttribute("produtos", new ArrayList<>());
        
        return "produtos_list_page";
    }
    
    @GetMapping("/cadastrar-produto")
    public String formCadastro(Model model) {
        
        model.addAttribute("produto", new ProdutoRequest());
        
        return "form_produto";
    }
    
    @GetMapping("/produtos/{id}/atualizar")
    public String formCadastro(@PathVariable String id, Model model) {
        
        model.addAttribute("produto", new ProdutoRequest());
        model.addAttribute("isEditingMode", true);
        
        return "form_produto";
    }
    
    @GetMapping("/produtos/{id}/deletar")
    public String deletarProduto(@PathVariable String id) {
        
        return "redirect:/produtos";
    }
    
    @PostMapping("/cadastrar-produto")
    public String formCadastro(@Valid @ModelAttribute("produto") ProdutoRequest request, BindingResult result) {
        
        if (result.hasErrors()) {
            return "form_produto";
        }
        
        return "redirect:/produtos";
    }
    
    @PostMapping("/produtos/{id}/atualizar")
    public String formAtualizacao(@Valid @PathVariable String id, @ModelAttribute("produto") ProdutoRequest request, BindingResult result) {
        
        if (result.hasErrors()) {
            return "form_produto";
        }
        
        return "redirect:/produtos";
    }
}
