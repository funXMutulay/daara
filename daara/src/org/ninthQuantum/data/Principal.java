package org.ninthQuantum.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Created By Mamadou Kébé
 */

@Entity
@Table(name="Principal")
public class Principal {
	
	
	
	
	public  Principal() {
		
	}

	public Principal(Long idPrinc, Etablissement etablissement, String nom, String prenom, String address, String email,
		String numTel) {
	super();
	this.idPrinc = idPrinc;
	this.etablissement = etablissement;
	this.nom = nom;
	this.prenom = prenom;
	this.address = address;
	this.email = email;
	this.numTel = numTel;
}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPrinc ;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")
		})
	private Etablissement etablissement ; 
	
	@Column(name="NOM")
	private String nom ;
	
	@Column(name="PRENOM")
	private String prenom ;
	
	@Column(name="ADDRESSE")
	private String address ;
	
	@Column(name="EMAIL")
	private String email ;
	
	@Column(name="NUME_TEL")
	private String numTel ;
	
	public Long getIdPrinc() {
		return idPrinc;
	}
	public void setIdPrinc(Long idPrinc) {
		this.idPrinc = idPrinc;
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
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}



}
