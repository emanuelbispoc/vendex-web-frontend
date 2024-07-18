package br.com.vendexpress.catalog.services.impl;

import br.com.vendexpress.catalog.dto.ProdutoRequest;
import br.com.vendexpress.catalog.dto.UsuarioRequest;
import br.com.vendexpress.catalog.dto.enums.FuncaoUsuario;
import br.com.vendexpress.catalog.entity.Produto;
import br.com.vendexpress.catalog.entity.Usuario;

public class Converter {

    public static UsuarioRequest toUsuarioRequest(Usuario usuario) {
        return new UsuarioRequest(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getSenha(),
                FuncaoUsuario.valueOf(usuario.getFuncao().name())
        );
    }
    
    public static ProdutoRequest toProdutoRequest(Produto produto) {
        return new ProdutoRequest(
                produto.getId(),
                produto.getCodigo(),
                produto.getTitulo(),
                produto.getCategoria(),
                produto.getPreco(),
                produto.getDetalhes(),
                produto.getQtdEstoque()
        );
    }
}
