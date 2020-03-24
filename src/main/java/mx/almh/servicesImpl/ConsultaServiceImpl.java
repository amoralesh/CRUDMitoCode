package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.almh.dao.IConsultaDAO;
import mx.almh.models.Consulta;
import mx.almh.services.IConsultaService;

@Service
public class ConsultaServiceImpl implements IConsultaService{
	
	@Autowired
	private IConsultaDAO dao;

	@Override
	public Consulta registrar(Consulta consulta) {
		
		consulta.getDetalleConsulta().forEach(detalle->{
			detalle.setConsulta(consulta);
		});
		return dao.save(consulta);
	}

	@Override
	public Consulta modificar(Consulta consulta) {
		
		consulta.getDetalleConsulta().forEach(detalle->{
			detalle.setConsulta(consulta);
		});
		return dao.save(consulta);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Consulta> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Consulta> listar() {
		return dao.findAll();
	}

}
