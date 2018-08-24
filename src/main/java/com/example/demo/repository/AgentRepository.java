package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Agent;
import com.example.demo.Entities.Site;


public interface AgentRepository extends JpaRepository<Agent,Long> {

	@Query("select c from Agent c where c.id=:id")
	public Agent affdetail(@Param("id") Long id);

	@Query("SELECT u FROM Agent u where u.id = :id")
	public Agent  findAgentById(@Param("id") Long id);
	

}
