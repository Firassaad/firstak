package com.example.demo.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

 
@Entity
public class ReponseQuestion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob @Column(name="CONTENT", length=1024)
	private String reponse;
	
//	@ManyToOne
//	private GroupeQuestion groupeQuestion;
//	
//	@ManyToOne
//	private Question question;
//	

	@ManyToOne
	private RapportEvenement rapportEvenement;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

//	public GroupeQuestion getGroupeQuestion() {
//		return groupeQuestion;
//	}
//
//	public void setGroupeQuestion(GroupeQuestion groupeQuestion) {
//		this.groupeQuestion = groupeQuestion;
//	}

	
//	public RapportEvenement getRapportEvenement() {
//		return rapportEvenement;
//	}
//
//	public void setRapportEvenement(RapportEvenement rapportEvenement) {
//		this.rapportEvenement = rapportEvenement;
//	}

//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}




	
	

}
