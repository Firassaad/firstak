package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Examen;
import com.example.demo.Entities.Site;
import com.example.demo.Entities.Questionqcm;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	@Query("select c from Questionqcm c where c.examen.id=:id")
	public List<Questionqcm> affqcm(@Param("id") Long id);
}
