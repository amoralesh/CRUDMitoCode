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

import mx.almh.models.Consulta;
import mx.almh.services.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	
	@Autowired
	private IConsultaService service;
	
	@GetMapping(produces = "application/json")
	public List<Consulta> listar(){
		
		return service.listar();
		
	}
	
	@GetMapping(value = "/{id}",produces ="application/json")
	public Optional<Consulta> listarId(@PathVariable("id") Integer id) {
		return service.listarId(id);
	}
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public Consulta registrar(@RequestBody Consulta consultad) {
		return service.registrar(consultad);
		
	}
	
	@PutMapping(produces = "application/json", consumes="application/json")
	public Consulta modificar(@RequestBody Consulta consulta) {
		return service.modificar(consulta);
		
	}
	
	@DeleteMapping
	public void eliminar (@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
