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

import mx.almh.models.Paciente;
import mx.almh.services.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	
	@Autowired
	private IPacienteService service;
	
	@GetMapping(produces = "application/json")
	public List<Paciente> listar(){
		
		return service.listar();
		
	}
	
	@GetMapping(value = "/{id}",produces ="application/json")
	public Optional<Paciente> listarId(@PathVariable("id") Integer id) {
		return service.listarId(id);
	}
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public Paciente registrar(@RequestBody Paciente paciente) {
		return service.registrar(paciente);
		
	}
	
	@PutMapping(produces = "application/json", consumes="application/json")
	public Paciente modificar(@RequestBody Paciente paciente) {
		return service.modificar(paciente);
		
	}
	
	@DeleteMapping
	public void eliminar (@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
