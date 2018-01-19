package org.ninthQuantum.daara.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Tuteur {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTuteur ;
	
	@ManyToOne
	@JoinColumns({
				@JoinColumn (name="NOM_ETUDIANT",referencedColumnName="NOM_ETUDIANT") 
				,@JoinColumn (name="PRENOM_ETUDIANT",referencedColumnName="PRENOM_ETUDIANT")
				,@JoinColumn (name="EMAIL_ETUDIANT",referencedColumnName="EMAIL_ETUDIANT")
				
				})
	private Etudiant etudiant ;
	
	
	private String nom ;
	private String prenom ;
	private String address ;
	private String email ;
	private String telNum;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public Long getIdTuteur() {
		return idTuteur;
	}
	public void setIdTuteur(Long idTuteur) {
		this.idTuteur = idTuteur;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	
}
