package nix.entity.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nix.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer> {
	public Transferencia findById(Integer id);

	public List<Transferencia> findAll(Sort sort);
	
	public List<Transferencia> findByExcluidoFalse(Sort sort);
}
