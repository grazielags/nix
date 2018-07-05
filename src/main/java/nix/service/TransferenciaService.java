package nix.service;

import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nix.entity.Transferencia;
import nix.entity.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
    private TransferenciaRepository transferenciaRepository;
	
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired(required = true)
    public TransferenciaService(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public TransferenciaService() {}

    public List<Transferencia> getAll() {
		List<Transferencia> transferencias = (List<Transferencia>) transferenciaRepository.findAll();
        return transferencias;
    }

    public Transferencia getById(Integer id) {
    	Transferencia transferencia = transferenciaRepository.findById(id);
        if(isNull(transferencia)) {
            throw new RuntimeException("Transferencia not found!");
        }
        return transferencia;
    }

    public Transferencia save(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }
}
