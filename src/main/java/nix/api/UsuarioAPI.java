package nix.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nix.api.mapper.UsuarioMapper;
import nix.service.UsuarioService;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioAPI {

	@Autowired
    private UsuarioService usuarioService;
	@Autowired
	private UsuarioMapper usuarioResourceAssembler;

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.GET)
//    public UsuarioDTO getAll() {
//        return usuarioResourceAssembler.toResource(usuarioService.getAll());
//    }
//    
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public UsuarioDTO getById(@PathVariable Integer id) {
//        return usuarioResourceAssembler.toResource(usuarioService.getById(id));
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST)
//    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioResource) {
//        return usuarioResourceAssembler.toResource(usuarioService.save(usuarioResourceAssembler.toDomain(usuarioResource)));
//    }

}
