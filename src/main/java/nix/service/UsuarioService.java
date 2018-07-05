package nix.service;

import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nix.entity.Usuario;
import nix.entity.repository.UsuarioRepository;

@Service
public class UsuarioService  {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired(required = true)
    public UsuarioService(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

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
