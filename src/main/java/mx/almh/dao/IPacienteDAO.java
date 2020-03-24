package mx.almh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.almh.models.Paciente;

public interface IPacienteDAO  extends JpaRepository<Paciente, Integer>{

}
