package org.ninthQuantum.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ninthQuantum.daara.entities.Etudiant;
import org.ninthQuantum.daara.entities.Matiere;

import entitiesId.ClasseId;

@Entity
@Table(name="CLASSE")
@IdClass(ClasseId.class)
public class Classe {

	@Id
	@Column(name="NIVEAU")
	private String niveau;
	
	@Id
	@Column(name="VARIANCE")
	private String variance;
	
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Etablissement etablissement ;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SURVEILLANT")
	private Surveillant surveillant ; 
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Etudiant> listEtudClasse = new ArrayList<>();
	
	
	@ManyToMany
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Collection<Professeur> listProfClasse = new ArrayList<>();
	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
		@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
	private Collection<Matiere> listMatClasse = new ArrayList<>();
	
	
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getVariance() {
		return variance;
	}
	public void setVariance(String variance) {
		this.variance = variance;
	}
	
	public void setListProfClasse(List<Professeur> listProfClasse) {
		this.listProfClasse = listProfClasse;
	}
	public Surveillant getSurveillant() {
		return surveillant;
	}
	public void setSurveillant(Surveillant surveillant) {
		this.surveillant = surveillant;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public Collection<Etudiant> getListEtudClasse() {
		return listEtudClasse;
	}
	public void setListEtudClasse(Collection<Etudiant> listEtudClasse) {
		this.listEtudClasse = listEtudClasse;
	}
	public Collection<Professeur> getListProfClasse() {
		return listProfClasse;
	}
	public void setListProfClasse(Collection<Professeur> listProfClasse) {
		this.listProfClasse = listProfClasse;
	}
	public Collection<Matiere> getListMatClasse() {
		return listMatClasse;
	}
	public void setListMatClasse(Collection<Matiere> listMatClasse) {
		this.listMatClasse = listMatClasse;
	}
	
	

	
	
	
}
