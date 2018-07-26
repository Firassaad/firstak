package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(name = "last_name")
	private String nom;

	@Column(name = "photo")
	private String photo;

	@Column(name = "first_name")
	private String prenom;

	private String cvUser;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String telephone;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "last_password_reset_date")
	private Date lastPasswordResetDate;

	@Column(name = "profil")
	private String profil;

	@Column(name = "language")
	private String langue;

	@Column(name = "idNotifM")
	private String idNotifM;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/******/

	@ManyToMany
	// @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinTable(name = "user_sites")
	private List<Site> sites;

	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Service> services;

	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RapportEvenement> rapportEvenements;



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	
	public Utilisateur(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*****************************************************************************************/


	// @JsonIgnore
	public List<Site> getSites() {
		return sites;
	}

	/*
	 * public ArrayList<String> getSitesnames() { ArrayList<String> arrayList =
	 * new ArrayList<String>(); for (int i = 0; i < sites.size(); i++)
	 * arrayList.add(sites.get(i).getName()); return arrayList; }
	 */

	/*
	 * public ArrayList<Long> getSitesids() { ArrayList<Long> arrayList = new
	 * ArrayList<Long>(); for (int i = 0; i < sites.size(); i++)
	 * arrayList.add(sites.get(i).getId()); return arrayList; }
	 */

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}


	@JsonIgnore
	public List<RapportEvenement> getRapportEvenements() {
		return rapportEvenements;
	}

	public void setRapportEvenements(List<RapportEvenement> rapportEvenements) {
		this.rapportEvenements = rapportEvenements;
	}

	public String getIdNotifM() {
		return idNotifM;

	}

	public void setIdNotifM(String idNotifM) {
		this.idNotifM = idNotifM;
	}



	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public String getCvUser() {
		return cvUser;
	}

	public void setCvUser(String cvUser) {
		this.cvUser = cvUser;
	}
}
