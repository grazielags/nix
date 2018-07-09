package nix.service;

import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nix.entity.Usuario;
import nix.entity.repository.UsuarioRepository;

@Service
public class UsuarioService  {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
    private EntityManager entityManagerFactory;

    public UsuarioService() {}

	public List<Usuario> getAll() {
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id);
        if(isNull(usuario)) {
            throw new RuntimeException("Usuário not found!");
        }
        return usuario;
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
