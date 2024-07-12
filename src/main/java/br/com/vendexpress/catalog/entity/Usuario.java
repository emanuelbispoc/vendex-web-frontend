package br.com.vendexpress.catalog.entity;

public class Usuario {
    
    public enum Funcao{
        ADMINISTRADOR,
        OPERADOR
    }
    
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private Funcao funcao;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha, Funcao funcao) {
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    
}
