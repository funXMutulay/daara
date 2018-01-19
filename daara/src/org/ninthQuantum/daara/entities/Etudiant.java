package org.ninthQuantum.daara.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.ninthQuantum.data.Classe;
import org.ninthQuantum.data.Etablissement;

import entitiesId.EtudiantId;

@Entity
@IdClass(EtudiantId.class)

public class Etudiant {
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
		@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
	private Classe classe;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Etablissement etablissement;
	
	@Id
	@Column(name="NOM_ETUDIANT")
	private String nom ;
	
	@Id
	@Column(name="PRENOM_ETUDIANT")
	private String prenom ;
	
	@Id
	@Column(name="EMAIL_ETUDIANT")
	private String email ;
	
	
	@Column(name="ADDRESSE_ETUDIANT")
	private String address ;
	
	
	
	@OneToMany
	private List<Tuteur> listTutEtud = new ArrayList<>();
	
	
	
	
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
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
	public List<Tuteur> getListTutEtud() {
		return listTutEtud;
	}
	public void setListTutEtud(List<Tuteur> listTutEtud) {
		this.listTutEtud = listTutEtud;
	}
	
	

}
