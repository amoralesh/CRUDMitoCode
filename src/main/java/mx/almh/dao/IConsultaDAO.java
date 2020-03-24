package mx.almh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.almh.models.Consulta;

public interface IConsultaDAO extends JpaRepository<Consulta, Integer>{

}
