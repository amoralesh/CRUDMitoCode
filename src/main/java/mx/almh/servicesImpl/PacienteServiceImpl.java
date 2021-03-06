package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.almh.dao.IPacienteDAO;
import mx.almh.models.Paciente;
import mx.almh.services.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	
	@Autowired
	private IPacienteDAO dao;
	
	@Override
	public Paciente registrar(Paciente t) {
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
	dao.deleteById(id);
		
	}
	
	@Override
	public Optional<Paciente> listarId(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}


}
