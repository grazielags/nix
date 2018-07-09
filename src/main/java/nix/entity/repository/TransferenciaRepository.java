package nix.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nix.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Long> {
	public Transferencia findById(Integer id);
}
