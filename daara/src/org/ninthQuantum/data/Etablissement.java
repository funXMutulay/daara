package org.ninthQuantum.data;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ninthQuantum.daara.entities.Etudiant;
import org.ninthQuantum.daara.entities.Matiere;

import entitiesId.EtablissementId;





@Entity
@Table(name="ETABLISSEMENT")
@IdClass(EtablissementId.class)
@NamedQueries({ @NamedQuery (name="etablissementParNom" , query="select  t   from Etablissement t " )})
public class Etablissement {
	
	@Id @GeneratedValue
	@Column(name="ID_ETABLISSEMENT")
	private Long idEtablissement;
	
	@Id
	@Column(name="NOM_ETABLISSEMENT")
	private String nom;
	
	@Column(name="ADDRESS_ETABLISSEMENT")
	private String address;
	
	@Column(name="REGION_ETABLISSEMENT")
	private String region;
	
	@Column(name="PAYS_ETABLISSEMENT")
	private String pays;
	
	@OneToOne(mappedBy="etablissement")
	private Principal principal;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Surveillant> listEtablissementSurv = new ArrayList<>();
	
	
	@OneToMany(cascade=CascadeType.ALL)
	
	private Collection<Professeur> listEtablissementProf = new ArrayList<>();
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	
	private Collection<Classe> listEtablissementClasse = new ArrayList<Classe>();
	
	@OneToMany(cascade=CascadeType.ALL)
	
	private Collection<Etudiant> listEtablissementEtud = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	
	private Collection<Matiere> listEtablissementMatiere = new ArrayList<>();
	
	
	
	
	public Etablissement() {
		
	}


	public Etablissement(Long idEtablissement, String nom, String address, String region, String pays, 
			Collection<Surveillant> listEtablissementSurv, Collection<Professeur> listEtablissementProf,
			Collection<Classe> listEtablissementClasse, Collection<Etudiant> listEtablissementEtud,
			Collection<Matiere> listEtablissementMatiere, Principal principal) {
		super();
		this.idEtablissement = idEtablissement;
		this.nom = nom;
		this.address = address;
		this.region = region;
		this.pays = pays;
		this.principal = principal;
		this.listEtablissementSurv = listEtablissementSurv;
		this.listEtablissementProf = listEtablissementProf;
		this.listEtablissementClasse = listEtablissementClasse;
		this.listEtablissementEtud = listEtablissementEtud;
		this.listEtablissementMatiere = listEtablissementMatiere;
	}
	
	
	public Etablissement(Long idEtablissement, String nom, String address, String region, String pays,
			Principal principal) {
		super();
		this.idEtablissement = idEtablissement;
		this.nom = nom;
		this.address = address;
		this.region = region;
		this.pays = pays;
		this.principal = principal;
	}


	public Long getIdEtablissement() {
		return idEtablissement;
	}
	public void setIdEtablissement(Long idEtablissement) {
		this.idEtablissement = idEtablissement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrinc(Principal principal) {
		this.principal = principal;
	}
	public Collection<Surveillant> getListEtablissementSurv() {
		return listEtablissementSurv;
	}
	public void setListEtablissementSurv(Collection<Surveillant> listEtablissementSurv) {
		this.listEtablissementSurv = listEtablissementSurv;
	}
	public Collection<Professeur> getListEtablissementProf() {
		return listEtablissementProf;
	}
	public void setListEtablissementProf(Collection<Professeur> listEtablissementProf) {
		this.listEtablissementProf = listEtablissementProf;
	}
	public Collection<Classe> getListEtablissementClasse() {
		return listEtablissementClasse;
	}
	public void setListEtablissementClasse(Collection<Classe> listEtablissementClasse) {
		this.listEtablissementClasse = listEtablissementClasse;
	}
	public Collection<Etudiant> getListEtablissementEtud() {
		return listEtablissementEtud;
	}
	public void setListEtablissementEtud(Collection<Etudiant> listEtablissementEtud) {
		this.listEtablissementEtud = listEtablissementEtud;
	}
	public Collection<Matiere> getListEtablissementMatiere() {
		return listEtablissementMatiere;
	}
	public void setListEtablissementMatiere(Collection<Matiere> listEtablissementMatiere) {
		this.listEtablissementMatiere = listEtablissementMatiere;
	}


	@Override
	public String toString() {
		return "Etablissement [idEtablissement=" + idEtablissement + ", nom=" + nom + ", address=" + address
				+ ", region=" + region + ", pays=" + pays + ", principal =" + principal + ", listEtablissementSurv="
				+ listEtablissementSurv + ", listEtablissementProf=" + listEtablissementProf
				+ ", listEtablissementClasse=" + listEtablissementClasse + ", listEtablissementEtud="
				+ listEtablissementEtud + ", listEtablissementMatiere=" + listEtablissementMatiere
				+ ", getIdEtablissement()=" + getIdEtablissement() + ", getNom()=" + getNom() + ", getAddress()="
				+ getAddress() + ", getRegion()=" + getRegion() + ", getPays()=" + getPays() + ", getPrinc()="
				+ getPrincipal() + ", getListEtablissementSurv()=" + getListEtablissementSurv()
				+ ", getListEtablissementProf()=" + getListEtablissementProf() + ", getListEtablissementClasse()="
				+ getListEtablissementClasse() + ", getListEtablissementEtud()=" + getListEtablissementEtud()
				+ ", getListEtablissementMatiere()=" + getListEtablissementMatiere() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
