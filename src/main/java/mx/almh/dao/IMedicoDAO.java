package mx.almh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.almh.models.Medico;

public interface IMedicoDAO extends JpaRepository<Medico, Integer>{

}
