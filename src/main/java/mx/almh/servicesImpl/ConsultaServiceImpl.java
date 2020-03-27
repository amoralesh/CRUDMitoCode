package mx.almh.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.almh.dao.IConsultaDAO;
import mx.almh.dao.IConsultaExamenDAO;
import mx.almh.dto.ConsultaListaExamenDTO;
import mx.almh.models.Consulta;
import mx.almh.services.IConsultaService;

@Service
public class ConsultaServiceImpl implements IConsultaService{
	
	@Autowired
	private IConsultaDAO dao;
	
	@Autowired
	private IConsultaExamenDAO ceDao;

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO) {
		
		consultaDTO.getConsulta().getDetalleConsulta().forEach(detalle->{
			detalle.setConsulta(consultaDTO.getConsulta());
		});
		 dao.save(consultaDTO.getConsulta());
		 
		 consultaDTO.getListaExamen().forEach(e->ceDao.registrar(consultaDTO.getConsulta().getIdConsulta(), e.getIdExamen()));
	return consultaDTO.getConsulta();
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

	@Override
	public Consulta registrar(Consulta t) {
		// TODO Auto-generated method stub
		return null;
	}


}
