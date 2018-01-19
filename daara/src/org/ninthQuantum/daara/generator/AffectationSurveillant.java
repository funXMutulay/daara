package org.ninthQuantum.daara.generator;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.ninthQuantum.daara.entities.Matiere;
import org.ninthQuantum.data.Classe;
import org.ninthQuantum.data.Etablissement;
import org.ninthQuantum.data.Surveillant;

@Entity
public class AffectationSurveillant {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AFFECTATION")
	private Long idAffect ;
	
	@ManyToOne
	@JoinColumn(name="ID_SURVEILLANT")
	private Surveillant Surv ;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Etablissement etablissement;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
		@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
	private Classe classe;
	
	@Column(name="ANNEE_SCOLAIRE")
	private String anneeScolaire; 
	
	public Long getIdAffect() {
		return idAffect;
	}
	public void setIdAffect(Long idAffect) {
		this.idAffect = idAffect;
	}
	
	
	public Surveillant getSurv() {
		return Surv;
	}
	public void setSurv(Surveillant surv) {
		Surv = surv;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public String getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	
	
	
	
	
}
