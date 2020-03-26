package mx.almh.dto;

import java.util.List;

import mx.almh.models.Consulta;
import mx.almh.models.Examen;

public class ConsultaListaExamenDTO {

	
	private Consulta consulta;
	
	private List<Examen> listaExamen;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getListaExamen() {
		return listaExamen;
	}

	public void setListaExamen(List<Examen> listaExamen) {
		this.listaExamen = listaExamen;
	}
	
	
}
