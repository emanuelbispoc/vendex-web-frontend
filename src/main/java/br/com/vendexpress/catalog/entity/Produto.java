package br.com.vendexpress.catalog.entity;

import java.math.BigDecimal;

public class Produto {
    
    private Long id;
    private String codigo;
    private String titulo;
    private String categoria;
    private BigDecimal preco;
    private String detalhes;
    private Long qtdEstoque;

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
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

    public String getDetalhes() {
        return detalhes;
    }

    public Long getId() {
        return id;
    }
    
}
