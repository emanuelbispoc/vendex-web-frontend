package br.com.vendexpress.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    
    @NotBlank(message = "O login deve ser preeenchido.")
    private String login;
    @NotBlank(message = "A senha deve ser preeenchido.")
    private String senha;

    public LoginRequest() {
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
