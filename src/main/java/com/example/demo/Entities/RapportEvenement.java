package com.example.demo.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RapportEvenement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Boolean isClosed;
	
//	@ManyToOne
//	private Site site;
//	
//	public Site getSite() {
//		return site;
//	}
//
//	public void setSite(Site site) {
//		this.site = site;
//	}


//	@ManyToOne
//	private Evenement evenement;
//	
//	@OneToMany(mappedBy = "rapportEvenement", cascade = CascadeType.ALL)
//    private List<ReponseQuestion> reponseQuestions;
//


	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateCreation;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateCloture;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
//	public Evenement getEvenement() {
//		return evenement;
//	}
//
//	public void setEvenement(Evenement evenement) {
//		this.evenement = evenement;
//	}
//
//	@JsonIgnore
//	public List<ReponseQuestion> getReponseQuestions() {
//		return reponseQuestions;
//	}
//
//	public void setReponseQuestions(List<ReponseQuestion> reponseQuestions) {
//		this.reponseQuestions = reponseQuestions;
//	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	
	
}
