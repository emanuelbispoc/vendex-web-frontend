package br.com.vendexpress.catalog.controller;

import br.com.vendexpress.catalog.dto.LoginRequest;
import br.com.vendexpress.catalog.dto.UsuarioRequest;
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
public class UsuarioController {

    @GetMapping("/login")
    public String efetuarLogin(Model model) {

        model.addAttribute("loginrequest", new LoginRequest());

        return "login_page";
    }

    @GetMapping("/cadastrar-usuario")
    public String formCadastro(Model model) {

        model.addAttribute("usuario", new UsuarioRequest());

        return "form_usuario";
    }
    
    @GetMapping("/usuarios/{id}/atualizar")
    public String formAtualizar(@PathVariable String id, Model model) {

        model.addAttribute("usuario", new UsuarioRequest());
        model.addAttribute("isEditingMode", true);

        return "form_usuario";
    }
    
    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {

        model.addAttribute("usuarios", new ArrayList<>());

        return "usuarios_list_page";
    }
    
    @GetMapping("/usuarios/{id}/deletar")
    public String deletarUsuario(@PathVariable String id) {

        return "redirect:/usuarios";
    }
    
    @PostMapping("/login")
    public String efetuarLogin(@Valid @ModelAttribute("loginrequest") LoginRequest request, BindingResult result) {

        if (result.hasErrors()) {
            return "login_page";
        }

        return "redirect:/";
    }
    
    @PostMapping("/cadastrar-usuario")
    public String formCadastro(@Valid @ModelAttribute("usuario") UsuarioRequest usuario, BindingResult result) {

        if (result.hasErrors()) {
            return "form_usuario";
        }
        
        return "redirect:/";
    }
    
    @PostMapping("/usuarios/{id}/atualizar")
    public String formAtualizacao(@Valid @PathVariable String id, @ModelAttribute("usuario") UsuarioRequest request, BindingResult result) {
        
        if (result.hasErrors()) {
            return "form_usuario";
        }
        
        return "redirect:/usuarios";
    }
    
}
