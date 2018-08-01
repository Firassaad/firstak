package com.example.demo.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GroupeQuestion {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name="titre",unique=true)
private String titre;
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
@OneToMany(mappedBy="groupeQuestion" ,cascade = CascadeType.ALL)
private List<Question> questions;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public List<Question> getQuestions() {
	return questions;
}
public void setQuestions(List<Question> questions) {
	this.questions = questions;
}

}
