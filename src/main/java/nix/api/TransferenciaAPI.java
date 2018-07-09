package nix.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nix.api.mapper.TransferenciaMapper;
import nix.entity.Transferencia;
import nix.service.TransferenciaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/transferencias")
public class TransferenciaAPI {
	
	@Autowired
    private TransferenciaService transferenciaService;
	@Autowired
    private TransferenciaMapper transferenciaMapper;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Transferencia> getAll() {
//    	return new ResponseEntity<List<TransferenciaDTO>>(transferenciaMapper.mapToDto(transferenciaService.getAll()), HttpStatus.OK);
    	return transferenciaService.getAll();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transferencia getById(@PathVariable Integer id) {
        return transferenciaService.getById(id);
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST)
//    public TransferenciaDTO save(@RequestBody TransferenciaDTO transferenciaResource) {
//        return transferenciaMapper.mapToDto(transferenciaService.save(transferenciaMapper.mapToEntity(transferenciaResource)));
//    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Transferencia save(@PathVariable Transferencia transferencia) {
        return transferenciaService.save(transferencia);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id) {
        transferenciaService.remove(id.longValue());
    }

}
