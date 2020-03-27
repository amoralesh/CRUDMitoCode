package mx.almh.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.webservices.WebServicesProperties.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mx.almh.exceptions.ModeloNotFoundException;
import mx.almh.models.Paciente;
import mx.almh.services.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	
	@Autowired
	private IPacienteService service;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Paciente>> listar(){
		
		List<Paciente> pacientes = new ArrayList<>();
		pacientes = service.listar();
		//return service.listar();
		return new ResponseEntity<List<Paciente>>(pacientes,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}",produces ="application/json")
	public Optional<Paciente> listarId(@PathVariable("id") Integer id) {
		Optional<Paciente> pac = service.listarId(id);

				if (!pac.isPresent()) {
				throw new ModeloNotFoundException("Id no encontrado"); 
					
				}
		
		return service.listarId(id);
	}
	
//	@PostMapping(produces = "application/json", consumes="application/json")
//	public Paciente registrar(@RequestBody Paciente paciente) {
//		return service.registrar(paciente);
//		
//	}
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public ResponseEntity<Object> registrar(@RequestBody Paciente paciente) {
		Paciente pac = new Paciente();
		pac=service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
//	@PutMapping(produces = "application/json", consumes="application/json")
//	public Paciente modificar(@RequestBody Paciente paciente) {
//		return service.modificar(paciente);
//		
//	}
	
	@PutMapping(produces = "application/json", consumes="application/json")
	public ResponseEntity<Object> modificar(@RequestBody Paciente paciente) {
		service.modificar(paciente);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
//	@DeleteMapping
//	public void eliminar (@PathVariable("id") Integer id) {
//		service.eliminar(id);
//	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar (@PathVariable("id") Integer id) {
		Optional<Paciente> pacE = service.listarId(id);
		if (!pacE.isPresent()) {
			throw new ModeloNotFoundException("Id no encontrado : "+ id);
		}else {
			service.eliminar(id);
		}
		
	}

}
