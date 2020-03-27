package mx.almh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Esto es información de paciente")
@Entity
@Table(name="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@ApiModelProperty(notes = "El nombre no debe aceptar menos de 3 caractares")
	@Size(min=3, message = "El nombre debe contener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@ApiModelProperty(notes = "El apellido no debe aceptar menos de 3 caractares")
	@Size(min=3, message = "El apellido debe contener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Size(min=8, max=8, message = "La cedula Profesional debe contener minimo y maximo 8 caracteres")
	@Column(name = "cedulaProfesional", nullable = false, unique = true, length=8)
	private String cedulaProfesional;
	
	@Size(min=3, max=150, message = "La dirección debe contener minimo 3 y maximo 150 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	
	@Size(min=10, max=10, message = "La dirección debe contener minimo y maximo 10 caracteres")
	@Column(name = "telefono", nullable = true, length = 10)
	private String telefono;
	
	@Column(name = "email",nullable = true, length = 55)
	private String email;
	
	

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getCedulaProfesional() {
		return cedulaProfesional;
	}

	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
