package org.ninthQuantum.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Surveillant {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SURVEILLANT")
	private Long idSurv ;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Etablissement etablissement ;
	
	@Column(name="NOM")
	private String nom ;
	@Column(name="PRENOM")
	private String prenom ;
	@Column(name="ADDRESSE")
	private String address ;
	@Column(name="EMAIL")
	private String email ;
	@Column(name="NUMERO_TEL")
	private String numTel ;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
		@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
	private Collection<Classe> listClasSurv = new ArrayList<>();
	
	
	public Collection<Classe> getListClasSurv() {
		return listClasSurv;
	}
	public void setListClasSurv(Collection<Classe> listClasSurv) {
		this.listClasSurv = listClasSurv;
	}
	public Long getIdSurv() {
		return idSurv;
	}
	public void setIdSurv(Long idSurv) {
		this.idSurv = idSurv;
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	

	
	
	
	

}
