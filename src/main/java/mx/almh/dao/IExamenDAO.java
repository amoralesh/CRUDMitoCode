package mx.almh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.almh.models.Examen;

public interface IExamenDAO extends JpaRepository<Examen, Integer>{

}
