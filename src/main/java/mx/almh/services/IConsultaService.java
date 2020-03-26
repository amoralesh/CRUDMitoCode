package mx.almh.services;

import mx.almh.dto.ConsultaListaExamenDTO;
import mx.almh.models.Consulta;

public interface IConsultaService  extends ICRUD<Consulta>{
	
	Consulta registrarTransaccional (ConsultaListaExamenDTO consultaDTO);

}
