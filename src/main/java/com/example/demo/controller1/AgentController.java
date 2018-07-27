package com.example.demo.controller1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agent;
import com.example.demo.repository1.AgentRepository;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	AgentRepository agentRepository;
	
	@PostMapping("/save")
	public Agent add(@RequestBody Agent agent) {
		return agentRepository.save(agent);
	}
	
	@GetMapping("/getAllAgent")
	public List<Agent> getUser() {
		return agentRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(Agent u) {
		agentRepository.delete(u);

	}
	@DeleteMapping("/deleteSome")
	public void deleteSomeUser(@Valid @RequestBody List<Agent> l) {
		for (int i =0 ; i < l.size(); i++) {
			agentRepository.deleteById(l.get(i).getId());
		}
		// return l;

	}
}
