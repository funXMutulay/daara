package org.ninthQuantum.daara.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.ninthQuantum.data.Classe;
import org.ninthQuantum.data.Etablissement;
import org.ninthQuantum.data.Professeur;

import entitiesId.MatiereId;

@Entity
@IdClass(MatiereId.class)
public class Matiere {

@Id
@Column(name="NOM_MATIERE")	
private String nomMat;


@Id
@Column(name="CODE_MATIERE")
private String codeMat;

@Column(name="COEFFICIENT_MATIERE")
private int coef;

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
	@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
private Etablissement etablissement ;

@ManyToMany(cascade=CascadeType.ALL)
@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
	@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
private Collection<Classe> listClasseMatiere= new ArrayList<>();

@ManyToMany(cascade=CascadeType.ALL)
@JoinColumn(name="ID_PROFESSEUR")
private Collection<Professeur> listProsseurMatiere= new ArrayList<>();	
	
	
	public String getNomMat() {
		return nomMat;
	}
	public void setNomMat(String nomMat) {
		this.nomMat = nomMat;
	}
	public String getCodeMat() {
		return codeMat;
	}
	public void setCodeMat(String codeMat) {
		this.codeMat = codeMat;
	}
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public Collection<Classe> getListClasseMatiere() {
		return listClasseMatiere;
	}
	public void setListClasseMatiere(Collection<Classe> listClasseMatiere) {
		this.listClasseMatiere = listClasseMatiere;
	}
	public Collection<Professeur> getListProsseurMatiere() {
		return listProsseurMatiere;
	}
	public void setListProsseurMatiere(Collection<Professeur> listProsseurMatiere) {
		this.listProsseurMatiere = listProsseurMatiere;
	}
	
	
	
}
