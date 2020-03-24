package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.almh.dao.IEspecialidadDAO;
import mx.almh.models.Especialidad;
import mx.almh.services.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService{

	
	@Autowired
	private IEspecialidadDAO dao;
	
	@Override
	public Especialidad registrar(Especialidad t) {
		return dao.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
	dao.deleteById(id);
		
	}
	
	@Override
	public Optional<Especialidad> listarId(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Especialidad> listar() {
		return dao.findAll();
	}


}
