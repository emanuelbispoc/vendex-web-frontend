package br.com.vendexpress.catalog.dto;

import br.com.vendexpress.catalog.dto.enums.FuncaoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {
    
    private Long id;
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Login é obrigatório.")
    private String login;
    @NotBlank(message = "Senha é obrigatório.")
    private String senha;
    @NotNull(message = "Função é obrigatório.")
    private FuncaoUsuario funcao;

    public UsuarioRequest() {
    }

    public UsuarioRequest(Long id, String nome, String login, String senha, FuncaoUsuario funcao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public FuncaoUsuario getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoUsuario funcao) {
        this.funcao = funcao;
    }
    
}
