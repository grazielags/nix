package nix.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nix.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	public Transferencia findById(Integer id);
}
