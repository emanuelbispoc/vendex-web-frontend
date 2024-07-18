package br.com.vendexpress.catalog.services.impl;

import br.com.vendexpress.catalog.entity.Usuario;
import br.com.vendexpress.catalog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioService.buscarPorLogin(login);
                
        if (usuario == null) {
            return null;
        }
        
        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getFuncao().name())
                .build();
    }
}
