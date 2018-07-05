package nix.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nix.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findById(Integer id);
}
