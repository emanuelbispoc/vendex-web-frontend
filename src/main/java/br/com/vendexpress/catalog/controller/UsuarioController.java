package br.com.vendexpress.catalog.controller;

import br.com.vendexpress.catalog.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping("/login")
    public String efetuarLogin(Model model) {

        model.addAttribute("loginrequest", new LoginRequest());

        return "login_page";
    }

    @PostMapping("/login")
    public String efetuarLogin(@Valid @ModelAttribute("loginrequest") LoginRequest request, BindingResult result) {

        if (result.hasErrors()) {
            return "login_page";
        }

        return "redirect:/";
    }
    
}
