package com.example.demo.Entities;



import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateService;*/
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date debutService;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date finService;

	
	 @ManyToMany(mappedBy = "services")
	 @JsonIgnore
	    private List<Agent> agents ;

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	@ManyToOne
	private Planning planning;
	
	
//	@ManyToOne
//	private Utilisateur utilisateur;
//	
	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

//	public Utilisateur getUtilisateur() {
//		return utilisateur;
//	}
//
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
/*
	public Date getDateService() {
		return dateService;
	}

	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}
*/
	
//	public Planning getPlanning() {
//		return planning;
//	}

	public Date getDebutService() {
		return debutService;
	}

	public void setDebutService(Date debutService) {
		this.debutService = debutService;
	}

	public Date getFinService() {
		return finService;
	}

	public void setFinService(Date finService) {
		this.finService = finService;
	}
//
//	public void setPlanning(Planning planning) {
//		this.planning = planning;
//	}

	
	
	
}
