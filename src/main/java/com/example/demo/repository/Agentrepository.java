package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.Agent;

public interface Agentrepository extends JpaRepository<Agent,Long> {
	

}
