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

import mx.almh.models.Especialidad;
import mx.almh.services.IEspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	
	@Autowired
	private IEspecialidadService service;
	
	@GetMapping(produces = "application/json")
	public List<Especialidad> listar(){
		
		return service.listar();
		
	}
	
	@GetMapping(value = "/{id}",produces ="application/json")
	public Optional<Especialidad> listarId(@PathVariable("id") Integer id) {
		return service.listarId(id);
	}
	
	@PostMapping(produces = "application/json", consumes="application/json")
	public Especialidad registrar(@RequestBody Especialidad especialidad) {
		return service.registrar(especialidad);
		
	}
	
	@PutMapping(produces = "application/json", consumes="application/json")
	public Especialidad modificar(@RequestBody Especialidad especialidad) {
		return service.modificar(especialidad);
		
	}
	
	@DeleteMapping
	public void eliminar (@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
