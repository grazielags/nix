package nix.api.mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nix.api.dto.TransferenciaDTO;
import nix.entity.Transferencia;
import nix.service.TransferenciaService;

@Component
public class TransferenciaMapper {

	@Autowired
	private TransferenciaService transferenciaService;

    public TransferenciaDTO mapToDto(Transferencia transferencia) {
    	TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
    	transferenciaDTO.setId(transferencia.getId());
//    	transferenciaDTO.setUsuario(transferencia.getUsuario());
    	transferenciaDTO.setPagadorNome(transferencia.getPagadorNome());
    	transferenciaDTO.setPagadorBanco(transferencia.getPagadorBanco());
    	transferenciaDTO.setPagadorAgencia(transferencia.getPagadorAgencia());
    	transferenciaDTO.setPagadorConta(transferencia.getPagadorConta());
    	transferenciaDTO.setBeneficiarioNome(transferencia.getBeneficiarioNome());
    	transferenciaDTO.setBeneficiarioBanco(transferencia.getBeneficiarioBanco());
    	transferenciaDTO.setBeneficiarioAgencia(transferencia.getBeneficiarioAgencia());
    	transferenciaDTO.setBeneficiarioConta(transferencia.getBeneficiarioConta());
    	transferenciaDTO.setValor(transferencia.getValor());
    	transferenciaDTO.setValorFormatado(transferencia.getValor().toString());
    	transferenciaDTO.setTipo(transferencia.getTipo());
    	transferenciaDTO.setStatus(transferencia.getStatus());
    	transferenciaDTO.setDataCriacao(transferencia.getDataCriacao() != null ? transferencia.getDataCriacao().getTime() : null);
    	transferenciaDTO.setExcluido(transferencia.isExcluido());
        return transferenciaDTO;
    }
    
    public List<TransferenciaDTO> mapToDto(List<Transferencia> entities) {
		List<TransferenciaDTO> dtos = new ArrayList<TransferenciaDTO>();
		for (Transferencia entity : entities) {
			if (entity != null) {
				dtos.add(this.mapToDto(entity));
			}
		}
		return dtos;
	}

    public Transferencia mapToEntity(TransferenciaDTO transferenciaDTO) {
    	if (transferenciaDTO != null) {
    		Transferencia transferencia = new Transferencia();
			if (transferenciaDTO.getId() != null) {
				transferencia = this.transferenciaService.getById(transferenciaDTO.getId());
				if (transferencia == null) {
					transferencia = new Transferencia();
				}
			} else {
				transferencia.setDataCriacao(Calendar.getInstance().getTime());
			}
	    	transferencia.setPagadorNome(transferenciaDTO.getPagadorNome());
	    	transferencia.setPagadorBanco(transferenciaDTO.getPagadorBanco());
	    	transferencia.setPagadorAgencia(transferenciaDTO.getPagadorAgencia());
	    	transferencia.setPagadorConta(transferenciaDTO.getPagadorConta());
	    	transferencia.setBeneficiarioNome(transferenciaDTO.getBeneficiarioNome());
	    	transferencia.setBeneficiarioBanco(transferenciaDTO.getBeneficiarioBanco());
	    	transferencia.setBeneficiarioAgencia(transferenciaDTO.getBeneficiarioAgencia());
	    	transferencia.setBeneficiarioConta(transferenciaDTO.getBeneficiarioConta());
	    	transferencia.setValor(transferenciaDTO.getValor());
	    	transferencia.setTipo(transferenciaDTO.getTipo());
	    	transferencia.setStatus(transferenciaDTO.getStatus());
	    	transferencia.setExcluido(transferenciaDTO.isExcluido());
	        return transferencia;
    	}
    	return null;
    }
}
