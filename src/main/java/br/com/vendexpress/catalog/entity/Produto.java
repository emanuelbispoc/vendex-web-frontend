package br.com.vendexpress.catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String titulo;
    private String categoria;
    private BigDecimal preco;
    private String detalhes;
    private Long qtdEstoque;

    public Produto(Long id, String codigo, String titulo, String categoria, BigDecimal preco, String detalhes, Long qtdEstoque) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.preco = preco;
        this.detalhes = detalhes;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto() {
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
