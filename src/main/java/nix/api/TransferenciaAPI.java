package nix.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import nix.api.dto.TransferenciaDTO;
import nix.api.mapper.TransferenciaMapper;
import nix.entity.Transferencia;
import nix.service.TransferenciaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/transferencias")
@Api(value="/v1/transferencias", description="Api de transferência")
public class TransferenciaAPI {
	
	@Autowired
    private TransferenciaService transferenciaService;
	@Autowired
    private TransferenciaMapper transferenciaMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TransferenciaDTO>> getAll() {
    	return new ResponseEntity<List<TransferenciaDTO>>(transferenciaMapper.mapToDto(transferenciaService.getAll()), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transferencia getById(@PathVariable Integer id) {
        return transferenciaService.getById(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransferenciaDTO> saveEdit(@PathVariable Integer id, @RequestBody TransferenciaDTO transferenciaDTO, @RequestParam("token") String token) {
    	Transferencia transferencia = transferenciaService.save(transferenciaMapper.mapToEntity(transferenciaDTO));
    	if("inválido".equals(transferencia.getStatus())) {
    		return new ResponseEntity<TransferenciaDTO>(transferenciaMapper.mapToDto(transferencia), HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<TransferenciaDTO>(transferenciaMapper.mapToDto(transferencia), HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransferenciaDTO> save(@RequestBody TransferenciaDTO transferenciaDTO, @RequestParam("token") String token) {
    	Transferencia transferencia = transferenciaService.save(transferenciaMapper.mapToEntity(transferenciaDTO));
    	if("inválido".equals(transferencia.getStatus())) {
    		return new ResponseEntity<TransferenciaDTO>(transferenciaMapper.mapToDto(transferencia), HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<TransferenciaDTO>(transferenciaMapper.mapToDto(transferencia), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id, @RequestParam("token") String token) {
        transferenciaService.remove(id);
    }

}
