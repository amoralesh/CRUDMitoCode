package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.almh.dao.IMedicoDAO;
import mx.almh.models.Medico;
import mx.almh.services.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService{

	
	@Autowired
	private IMedicoDAO dao;
	
	@Override
	public Medico registrar(Medico t) {
		return dao.save(t);
	}

	@Override
	public Medico modificar(Medico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
	dao.deleteById(id);
		
	}
	
	@Override
	public Optional<Medico> listarId(int id) {
		return dao.findById(id);
	}


	@Override
	public List<Medico> listar() {
		return dao.findAll();
	}


}
