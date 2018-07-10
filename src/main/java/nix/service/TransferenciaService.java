package nix.service;

import static java.util.Objects.isNull;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nix.entity.Transferencia;
import nix.entity.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
    private TransferenciaRepository transferenciaRepository;
	
	@Autowired
    private EntityManager entityManagerFactory;

    public TransferenciaService() {}

    public List<Transferencia> getAll() {
		List<Transferencia> transferencias = (List<Transferencia>) transferenciaRepository.findByExcluidoFalse(new Sort(Sort.Direction.DESC, "id"));
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
    	LocalTime horarioInicio = LocalTime.of(10, 0);
    	LocalTime horarioTermino = LocalTime.of(16, 0);
    	LocalTime horarioAtual = LocalTime.now();
    	
    	if(transferencia.getPagadorBanco() == transferencia.getBeneficiarioBanco()) {
			transferencia.setTipo("CC");
		} else if(transferencia.getValor() < 5000
				&& (horarioAtual.isBefore(horarioTermino) || horarioAtual.equals(horarioTermino))
				&& (horarioAtual.isAfter(horarioInicio) || horarioAtual.equals(horarioTermino))) {
			transferencia.setTipo("TED");
		} else {
			transferencia.setTipo("DOC");
		}
    	if(transferencia.getValor() > 100000) {
    		transferencia.setStatus("inválido");
    	} else {
    		transferencia.setStatus("processado");
    	}
    	return transferenciaRepository.save(transferencia);
    }
    
    public void remove(Integer id) {
    	Transferencia transferencia = this.getById(id);
    	transferencia.setExcluido(true);
    	this.save(transferencia);
    }
}
