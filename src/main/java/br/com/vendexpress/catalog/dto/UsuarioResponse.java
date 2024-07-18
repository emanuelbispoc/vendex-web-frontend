package br.com.vendexpress.catalog.dto;

import br.com.vendexpress.catalog.dto.enums.FuncaoUsuario;

public class UsuarioResponse {
    
    private final Long id;    
    private final String nome;
    private final FuncaoUsuario funcao;

    public UsuarioResponse(Long id, String nome, FuncaoUsuario funcao) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public FuncaoUsuario getFuncao() {
        return funcao;
    }  
    
}
