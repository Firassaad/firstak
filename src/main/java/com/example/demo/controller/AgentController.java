package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agent;
import com.example.demo.Entities.Planning;
import com.example.demo.Entities.ReponseQuestion;
import com.example.demo.Entities.Service;
import com.example.demo.Entities.Site;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.ReponseQuestionRepository;
import com.example.demo.repository.SiteRepository;

import net.bytebuddy.asm.Advice.Return;

@CrossOrigin("*")
@RestController
public class AgentController {
	@Autowired
	AgentRepository r;
	@Autowired
	SiteRepository site;
	@Autowired 
	ReponseQuestionRepository reponseQuestionRepository;
	
	
	private List<Agent> l1;
	private List<Agent> l12;

	@GetMapping("/agent/afficher/{id}")

	public List<Agent> afficheragent(@PathVariable(value = "id") Long id) {
		int i, j;
		List<Agent> a = new ArrayList<>();
		Site s = site.affliste(id);
		Planning p = s.getPlanning();
		List<Service> ser = p.getServices();
		for (i = 0; i < ser.size(); i++) {
			for (j = 0; j < ser.get(i).getAgents().size(); j++) {
				a.add(ser.get(i).getAgents().get(j));
			}
		}
		return a;
	}

	@GetMapping("/agent/affichersites")
	public List<Site> affichersite() {
		return site.findAll();
	}

	@PostMapping("/save")
	public Agent add(@RequestBody Agent agent) {
		return r.save(agent);
	}

	@GetMapping("/getAllAgent")
	public List<Agent> getUser() {
		return r.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(Agent u) {
		r.delete(u);

	}

	@DeleteMapping("/deleteSome")
	public void deleteSomeUser(@Valid @RequestBody List<Agent> l) {
		for (int i = 0; i < l.size(); i++) {
			r.deleteById(l.get(i).getId());
		}
		// return l;

	}

	@GetMapping("/agent/afficher1/{id}")
	public List<Agent> getListAgentBySiteId(@PathVariable(value = "id") Long site_id) {
		List<Site> l = site.findAll();
		List<Agent> l3 = null;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getId() == site_id)
				l3 = l.get(i).getPlanning().getServices().get(i).getAgents();

		}
		return l3;
	}

	@GetMapping("/agent/chercher/{nom}")
	public List<Agent> chercher(@PathVariable(value = "nom") String nom) {
		List<Agent> l = r.findAll();
		l12 = null;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getNom() == nom)
				l12.add(l.get(i));
		}
		return l12;

	}

	@GetMapping("/agent/getListReponses/{id}")
	public List<ReponseQuestion> getListReponseByAgentId(@PathVariable(value="id") Long agent_id){
		List<ReponseQuestion> lrq = reponseQuestionRepository.findAll();
		List<ReponseQuestion> lu = null; 
		for(int i=0 ; i<lrq.size() ; i++)
			if(lrq.get(i).getAgent().getId()==agent_id)
		    lu = (List<ReponseQuestion>) lrq.get(i);
		return lu;		
	}

}
