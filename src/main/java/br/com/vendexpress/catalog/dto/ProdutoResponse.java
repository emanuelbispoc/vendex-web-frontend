package br.com.vendexpress.catalog.dto;

import java.math.BigDecimal;

public class ProdutoResponse {
    
    private final Long id;
    private final String codigo;
    private final String titulo;
    private final String categoria;
    private final BigDecimal preco;
    private final Long qtdEstoque;

    public ProdutoResponse(Long id, String codigo, String titulo, String categoria, BigDecimal preco, Long qtdEstoque) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Long getQtdEstoque() {
        return qtdEstoque;
    }     
}
