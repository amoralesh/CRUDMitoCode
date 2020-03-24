package mx.almh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(name="nombre",nullable = false,length = 70)
	private String nombre;
	
	@Column(name="apellidos", nullable = false,length = 70)
	private String apellidos;
	
	@Column(name="rfcMedico",nullable = false,length = 12)
	private String rfcMedico;

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRfcMedico() {
		return rfcMedico;
	}

	public void setRfcMedico(String rfcMedico) {
		this.rfcMedico = rfcMedico;
	}
	

}
