package com.example.demo.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Question")
public class Question {
	
	
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="nomQuestion")
	private String nomQuestion;
	
	public String getGroupQuestion() {
		return groupQuestion;
	}

	public void setGroupQuestion(String groupQuestion) {
		this.groupQuestion = groupQuestion;
	}


	
	@Column(name="menuDeroulantExistant")
	private String menuDeroulantExistant;
	
	@Column(name="orderQ")
	private Integer orderQ;
	
	@ManyToOne
	private Groupquestion q;
	public Groupquestion getQ() {
		return q;
	}

	public void setQ(Groupquestion q) {
		this.q = q;
	}

	//Text Informatif
	@Column(name="libelle")
	private String libelle ;
	
	@Column(name="groupQuestion")
	private String groupQuestion ;
	@ManyToOne
	private GroupeQuestion groupeQuestion;

	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<ReponseQuestion> reponseQuestions; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomQuestion() {
		return nomQuestion;
	}

	public void setNomQuestion(String nomQuestion) {
		this.nomQuestion = nomQuestion;
	}




	public String getMenuDeroulantExistant() {
		return menuDeroulantExistant;
	}

	public void setMenuDeroulantExistant(String menuDeroulantExistant) {
		this.menuDeroulantExistant = menuDeroulantExistant;
	}
    

	public Integer getOrderQ() {
		return orderQ;
	}

	public void setOrderQ(Integer orderQ) {
		this.orderQ = orderQ;
	}

	@JsonIgnore
	public List<ReponseQuestion> getReponseQuestions() {
		return reponseQuestions;
	}

	public void setReponseQuestions(List<ReponseQuestion> reponseQuestions) {
		this.reponseQuestions = reponseQuestions;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
