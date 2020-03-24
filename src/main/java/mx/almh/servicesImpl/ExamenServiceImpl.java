package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.almh.dao.IExamenDAO;
import mx.almh.models.Examen;
import mx.almh.services.IExamenService;

@Service
public class ExamenServiceImpl implements IExamenService{

	
	@Autowired
	private IExamenDAO dao;
	
	@Override
	public Examen registrar(Examen t) {
		return dao.save(t);
	}

	@Override
	public Examen modificar(Examen t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
	dao.deleteById(id);
		
	}
	
	@Override
	public Optional<Examen> listarId(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Examen> listar() {
		return dao.findAll();
	}


}
