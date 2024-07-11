package br.com.vendexpress.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {
    
    private Long id;
    @NotBlank(message = "Código é obrigatório.")
    private String codigo;
    @NotBlank(message = "Título é obrigatório.")
    private String titulo;
    @NotBlank(message = "Categoria é obrigatório.")
    private String categoria;
    @NotNull(message = "Preço é obrigatório.")
    private BigDecimal preco;
    @NotBlank(message = "Detalhes é obrigatório.")
    private String detalhes;
    @NotNull(message = "Quantidade do estoque é obrigatório.")
    private Long qtdEstoque;

    public ProdutoRequest(Long id, String codigo, String titulo, String categoria, BigDecimal preco, String detalhes, Long qtdEstoque) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.preco = preco;
        this.detalhes = detalhes;
        this.qtdEstoque = qtdEstoque;
    }

    public ProdutoRequest() {
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

    public String getDetalhes() {
        return detalhes;
    }

    public Long getQtdEstoque() {
        return qtdEstoque;
    }

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
    
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
}
