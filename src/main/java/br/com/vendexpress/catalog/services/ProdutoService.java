package br.com.vendexpress.catalog.services;

import br.com.vendexpress.catalog.dto.ProdutoRequest;
import br.com.vendexpress.catalog.dto.ProdutoResponse;
import java.util.List;

public interface ProdutoService {
    void cadastrar(ProdutoRequest cadastroRequest);
    List<ProdutoResponse> listarTodos();
    void atualizar(ProdutoRequest produtoRequest);
    void remover(Long id);
    ProdutoRequest buscarComoRequestPorId(Long id);
}
