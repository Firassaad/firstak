package com.example.demo.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Examen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="nom",unique=true)
		private String nom;

	@OneToMany(mappedBy="examen")
	@JsonIgnore
	private List<Questionqcm> questionsq;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Questionqcm> getQuestionsq() {
		return questionsq;
	}

	public void setQuestionsq(List<Questionqcm> questionsq) {
		this.questionsq = questionsq;
	}
	

}
