package nix.service;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
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
//    	LocalDateTime horarioAtual = new LocalDateTimeParser();
    	if(transferencia.getPagadorBanco() == transferencia.getBeneficiarioBanco()) {
    		transferencia.setTipo("CC");
    	}
//    	if() {
//    		transferencia.setTipo("CC");
//    	}
        return transferenciaRepository.save(transferencia);
    }
    
    public void remove(Long id) {
        transferenciaRepository.delete(id);
    }
}
