package com.example.demo.Entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Evenement")
public class Evenement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="nom",unique=true)
	private String nom;
	
	@Column(name="categorie")
	private String categorie;
	
	@Column(name="profil")
	private String profil;
	
	@Column(name="type")
	private String type;
	
	@Column(name="priorite")
	private String priorite;
	
	@Column(name="visible")
	private Boolean visible;
	
	@Column(name="ouvert")
	private Boolean ouvert;
	
	@Column(name="nbrjour")
	private Integer nbrjour;
	
	@Column(name="description")
	private String description;
	
	@Column(name="assigne")
	private Boolean assigne;
	
	@Column(name="statut")
	private Boolean statut;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date dateCreation;
	
//	@OneToMany(mappedBy = "evenement")
//    private List<GroupeQuestion> groupeQuestions;
//
// 
//    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
//    private List<RapportEvenement> rapportEvenements;


//    @ManyToOne
//    private Site site; 
//    
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public Integer getNbrjour() {
		return nbrjour;
	}

	public void setNbrjour(Integer nbrjour) {
		this.nbrjour = nbrjour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAssigne() {
		return assigne;
	}

	public void setAssigne(Boolean assigne) {
		this.assigne = assigne;
	}
	
	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
//
//	@JsonIgnore
//	public List<GroupeQuestion> getGroupeQuestions() {
//		return groupeQuestions;
//	}
//
//	public void setGroupeQuestions(List<GroupeQuestion> groupeQuestions) {
//		this.groupeQuestions = groupeQuestions;
//	}
//	

//	@JsonIgnore
//	public List<RapportEvenement> getRapportEvenements() {
//		return rapportEvenements;
//	}
//
//	public void setRapportEvenements(List<RapportEvenement> rapportEvenements) {
//		this.rapportEvenements = rapportEvenements;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
