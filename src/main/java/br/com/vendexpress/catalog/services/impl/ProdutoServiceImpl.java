package br.com.vendexpress.catalog.services.impl;

import br.com.vendexpress.catalog.dto.ProdutoRequest;
import br.com.vendexpress.catalog.dto.ProdutoResponse;
import br.com.vendexpress.catalog.entity.Produto;
import br.com.vendexpress.catalog.repositories.ProdutoRepository;
import br.com.vendexpress.catalog.services.ProdutoService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(ProdutoRequest cadastroRequest) {
        repository.save(toEntity(cadastroRequest));
    }

    @Override
    public List<ProdutoResponse> listarTodos() {
        return toResponseList(repository.findAll());
    }

    @Override
    public void atualizar(ProdutoRequest produtoRequest) {
        Produto produtoAtual = buscarOProdutoPeloId(produtoRequest.getId());
        
        produtoAtual.setCodigo(produtoRequest.getCodigo());
        produtoAtual.setTitulo(produtoRequest.getTitulo());
        produtoAtual.setCategoria(produtoRequest.getCategoria());
        produtoAtual.setDetalhes(produtoRequest.getDetalhes());
        produtoAtual.setPreco(produtoRequest.getPreco());
        produtoAtual.setQtdEstoque(produtoRequest.getQtdEstoque());
        
        repository.save(produtoAtual);
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public ProdutoRequest buscarComoRequestPorId(Long id) {
        Produto produto = buscarOProdutoPeloId(id);
        
        return Converter.toProdutoRequest(produto);
    }
    
    private Produto buscarOProdutoPeloId(Long id) {
        return repository.findById(id).get();
    }
    
    private Produto toEntity(ProdutoRequest produtoRequest) {
        return new Produto(
                null,
                produtoRequest.getCodigo(),
                produtoRequest.getTitulo(),
                produtoRequest.getCategoria(),
                produtoRequest.getPreco(),
                produtoRequest.getDetalhes(),
                produtoRequest.getQtdEstoque()
        );
    }
    
    private List<ProdutoResponse> toResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(mapper -> new ProdutoResponse(
                        mapper.getId(),
                        mapper.getCodigo(),
                        mapper.getTitulo(),
                        mapper.getCategoria(),
                        mapper.getPreco(),
                        mapper.getQtdEstoque())
                )
                .toList();
    }
}
