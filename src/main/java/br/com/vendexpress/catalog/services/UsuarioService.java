package br.com.vendexpress.catalog.services;

import br.com.vendexpress.catalog.dto.UsuarioRequest;
import br.com.vendexpress.catalog.dto.UsuarioResponse;
import br.com.vendexpress.catalog.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    void cadastrar(UsuarioRequest cadastroRequest);
    Usuario buscarPorId(Long id);
    Usuario buscarPorLogin(String login);
    List<UsuarioResponse> listarTodos();
    void atualizar(UsuarioRequest usuarioRequest);
    void remover(Long id);
    UsuarioRequest buscarComoRequestPorId(Long id);
}
