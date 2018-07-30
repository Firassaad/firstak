package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agent;
import com.example.demo.Entities.Planning;
import com.example.demo.Entities.Service;
import com.example.demo.Entities.Site;
import com.example.demo.repository.Agentrepository;
import com.example.demo.repository.SiteRepository;
@CrossOrigin("*") 
@RestController
public class AgentController {
@Autowired
Agentrepository r;
@Autowired
SiteRepository site;
@GetMapping("/agent/afficher/{id}")

public List<Agent> afficheragent(@PathVariable(value="id") Long id)
{
int i,j;	
	List<Agent>a = new ArrayList<>();
Site s=site.affliste(id);
Planning p=s.getPlanning();
List<Service>ser=p.getServices();
for(i=0;i<ser.size();i++)
{
	for(j=0;j<ser.get(i).getAgents().size();j++)
	{
		a.add(ser.get(i).getAgents().get(j));	}
	}
return a;
	}
@GetMapping("/agent/affichersites")
public List<Site> affichersite()
{
	return site.findAll();}


}