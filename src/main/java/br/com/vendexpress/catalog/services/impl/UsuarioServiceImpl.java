package br.com.vendexpress.catalog.services.impl;

import br.com.vendexpress.catalog.dto.UsuarioRequest;
import br.com.vendexpress.catalog.dto.UsuarioResponse;
import br.com.vendexpress.catalog.dto.enums.FuncaoUsuario;
import br.com.vendexpress.catalog.entity.Usuario;
import br.com.vendexpress.catalog.exceptions.BusinessException;
import br.com.vendexpress.catalog.repositories.UsuarioRepository;
import br.com.vendexpress.catalog.services.UsuarioService;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repostory;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository repostory, PasswordEncoder passwordEncoder) {
        this.repostory = repostory;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void cadastrar(UsuarioRequest cadastroRequest) {
        repostory.save(toEntity(cadastroRequest));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repostory.findById(id).get();
    }
    
    @Override
    public Usuario buscarPorLogin(String login) {
        return repostory.findByLogin(login)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado."));
    }

    @Override
    public List<UsuarioResponse> listarTodos() {
        return toResponseList(repostory.findAll());
    }
    
    @Override
    public void atualizar(UsuarioRequest usuarioRequest) {
        Usuario usuarioAtual = buscarPorId(usuarioRequest.getId());
        
        usuarioAtual.setNome(usuarioRequest.getNome());
        usuarioAtual.setLogin(usuarioRequest.getLogin());
        usuarioAtual.setFuncao(Usuario.Funcao.valueOf(usuarioRequest.getFuncao().name()));
        
        repostory.save(usuarioAtual);
    }
    
    @Override
    public void remover(Long id) {
        repostory.deleteById(id);
    }
    
    @Override
    public UsuarioRequest buscarComoRequestPorId(Long id) {
        Usuario usuario = buscarPorId(id);
        
        return Converter.toUsuarioRequest(usuario);
    }

    private Usuario toEntity(UsuarioRequest usuarioRequest) {
        return new Usuario(
                null,
                usuarioRequest.getNome(),
                usuarioRequest.getLogin(),
                criptografarSenha(usuarioRequest.getSenha()),
                Usuario.Funcao.valueOf(usuarioRequest.getFuncao().name())
        );
    }

    private String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    private List<UsuarioResponse> toResponseList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(mapper -> new UsuarioResponse(mapper.getId(), mapper.getNome(), FuncaoUsuario.valueOf(mapper.getFuncao().name())))
                .toList();
    }
}
