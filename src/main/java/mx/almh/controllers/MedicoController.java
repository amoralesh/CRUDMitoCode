package mx.almh.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.almh.models.Medico;
import mx.almh.services.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	
	@Autowired
	private IMedicoService service;
	
	@GetMapping(produces = "application/json")
	public List<Medico> listar(){
		
		return service.listar();
		
	}
	
	@GetMapping(value = "/{id}",produces ="application/json")
	public Optional<Medico> listarId(@PathVariable("id") Integer id) {
		return service.listarId(id);
	}
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public Medico registrar(@RequestBody Medico medico) {
		return service.registrar(medico);
		
	}
	
	@PutMapping(produces = "application/json", consumes="application/json")
	public Medico modificar(@RequestBody Medico medico) {
		return service.modificar(medico);
		
	}
	
	@DeleteMapping
	public void eliminar (@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
