package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
	@Query("SELECT u FROM User u where u.id = :id")
	public Agent  findAgentById(@Param("id") Long id);

}
