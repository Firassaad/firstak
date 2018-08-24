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
import com.example.demo.Entities.Examen;
import com.example.demo.Entities.Groupquestion;
import com.example.demo.Entities.Planning;
import com.example.demo.Entities.Question;
import com.example.demo.Entities.Questionqcm;
import com.example.demo.Entities.ReponseQuestion;

import com.example.demo.Entities.Service;
import com.example.demo.Entities.Site;
import com.example.demo.repository.AgentRepository;

import com.example.demo.repository.ExamenRepository;
import com.example.demo.repository.GroupquestionRepository;
import com.example.demo.repository.QuestionRepository;

import com.example.demo.repository.ReponseQuestionRepository;

import com.example.demo.repository.SiteRepository;

import net.bytebuddy.asm.Advice.Return;

@CrossOrigin("*")
@RestController
public class AgentController {

	@Autowired
	AgentRepository r;
	@Autowired
	ExamenRepository examen;
	@Autowired
	SiteRepository site;

	@Autowired
	QuestionRepository question;
	@Autowired
	 GroupquestionRepository g;
	@Autowired 
	ReponseQuestionRepository reponseQuestionRepository;
	
	
	private List<Agent> l1;
	private List<Agent> l12;

	@GetMapping("/agent/afficher/site")

	//public List<Agent> afficheListAgentBySiteId(@PathVariable(value = "id") Long id) {

	public List<Agent> afficheragent( Long id) {
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
	@GetMapping("/agent/getAgentById")
	public Agent getAgentById(Long id ) {
		return r.findAgentById(id);
	}

	@GetMapping("/agent/recherche/{nom}/{id}")
	public List<Agent> rechercheagent(@PathVariable(value = "nom") String nom, @PathVariable(value = "id") Long id) {
		List<Agent> b = new ArrayList<>();
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
		for (i = 0; i < a.size(); i++) {
			if (a.get(i).getNom().equals(nom)) {
				b.add(a.get(i));
			}
		}
		return b;
	}

	

	

	
	@GetMapping("/site/affichersites")

	public List<Site> affichersite() {
		return site.findAll();
	}
	@GetMapping("/agent/getAllAgent")
	public List<Agent>getallAgent(){
		return r.findAll();
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

	@GetMapping("/agent/afficher/{id}")
	public List<Agent> getListAgentBySiteId(@PathVariable(value = "id") Long site_id) {
		List<Site> l = site.findAll();
		List<Agent> l3 = null;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getId() == site_id)
				l3 = l.get(i).getPlanning().getServices().get(i).getAgents();

		}
		return l3;
	}
	@GetMapping("/question/afficherquestions")
	public  List<Question> listquestion()
	{
	 return question.findAll();	
	}
	@GetMapping("/question/groupquestions")	
	public List<Groupquestion> listgroup()
	{
		return g.findAll();	}
	
	@GetMapping("/question/groupe")
	public List<Groupquestion> listype()
	{List<String> t=new ArrayList<>();
	List<Groupquestion> t1=new ArrayList<>();
	List <Question> q=new ArrayList<>();
	q=question.findAll();
	int i,j;
		for(i=0;i<q.size();i++)
	{
			System.out.println("++++++++++++++++++++++++++++++i"+i);
		for(j=0;j<t1.size();j++)
		{
			System.out.println("++++++++++++++++++++++++++++++j"+j);
			if(t1.get(j).getNomgroupe().equals(q.get(i).getQ().getNomgroupe()))
			{
				break;
			}
				
		}
		System.out.println("++++++++++++++++++++++++++++++j"+j);
		if(j==t1.size())
		{
			System.out.println("+insert+++++++++++++++++++++++++++++j"+j);
			t1.add(q.get(i).getQ());
		}
	}
	return t1;
		}
	@GetMapping("/agent/afficherdetail/{id}")


	public Agent affichedetailagent(@PathVariable(value = "id") Long id) 
		{
		return r.affdetail(id);
		}
	@GetMapping("/agent/afficherexamens")
	public List<Examen> afficherexam()
	{
		return examen.findAll();
	}
	@GetMapping("/examen/question/{id}")
	public List<Questionqcm>afficherqcm(@PathVariable(value="id")Long id)
	{
		return examen.affqcm(id);
	}

	@GetMapping("/agent/chercher")
//	public List<Agent> chercher(@PathVariable(value = "nom") String nom) {
	public List<Agent> chercher(String nom) {

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
