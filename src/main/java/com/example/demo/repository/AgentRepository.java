package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Agent;

public interface AgentRepository extends JpaRepository<Agent,Long> {
	@Query("SELECT u FROM Agent u where u.id = :id")
	public Agent  findAgentById(@Param("id") Long id);

}
