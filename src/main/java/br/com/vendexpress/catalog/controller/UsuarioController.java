package br.com.vendexpress.catalog.controller;

import br.com.vendexpress.catalog.dto.LoginRequest;
import br.com.vendexpress.catalog.dto.UsuarioRequest;
import br.com.vendexpress.catalog.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String efetuarLogin(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("loginrequest", new LoginRequest());
            return "login_page";
        }

        return "redirect:/";
    }

    @GetMapping("/cadastrar-usuario")
    public String formCadastro(Model model) {

        model.addAttribute("usuario", new UsuarioRequest());

        return "form_usuario";
    }
    
    @GetMapping("/usuarios/{id}/atualizar")
    public String formAtualizar(@PathVariable String id, Model model) {

        model.addAttribute("usuario", usuarioService.buscarComoRequestPorId(Long.valueOf(id)));
        model.addAttribute("isEditingMode", true);

        return "form_usuario";
    }
    
    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {

        model.addAttribute("usuarios", usuarioService.listarTodos());

        return "usuarios_list_page";
    }
    
    @GetMapping("/usuarios/{id}/deletar")
    public String deletarUsuario(@PathVariable String id) {

        usuarioService.remover(Long.valueOf(id));
        
        return "redirect:/usuarios";
    }
  
    @PostMapping("/cadastrar-usuario")
    public String formCadastro(@Valid @ModelAttribute("usuario") UsuarioRequest usuario, BindingResult result) {

        if (result.hasErrors()) {
            return "form_usuario";
        }
        
        usuarioService.cadastrar(usuario);
        
        return "redirect:/";
    }
    
    @PostMapping("/usuarios/{id}/atualizar")
    public String formAtualizacao(@Valid @ModelAttribute("usuario") UsuarioRequest request, BindingResult result, Model model, @PathVariable String id) {
        
        if (result.hasErrors()) {
            model.addAttribute("isEditingMode", true);
            return "form_usuario";
        }
        
        usuarioService.atualizar(request);
        
        return "redirect:/usuarios";
    }
    
}
