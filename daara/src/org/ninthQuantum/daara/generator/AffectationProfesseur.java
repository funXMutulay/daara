package org.ninthQuantum.daara.generator;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.ninthQuantum.daara.entities.Matiere;
import org.ninthQuantum.data.Classe;
import org.ninthQuantum.data.Etablissement;
import org.ninthQuantum.data.Professeur;

@Entity
public class AffectationProfesseur {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AFFECTATION_PROFESSEUR")
	private Long idAffect ;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="ID_ETABLISSEMENT",referencedColumnName="ID_ETABLISSEMENT" ),
		@JoinColumn(name="NOM_ETABLISSEMENT",referencedColumnName="NOM_ETABLISSEMENT")})
	private Etablissement etablissement;
	
	@Column(name="ANNEE_SCOLAIRE")
	private String anneeScolaire;
	
	@ManyToOne
	@JoinColumn(name="ID_PROF")
	private Professeur prof ;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="NIVEAU",referencedColumnName="NIVEAU" ),
		@JoinColumn(name="VARIANCE",referencedColumnName="VARIANCE")})
	private Classe classe;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="CODE_MATIERE",referencedColumnName="CODE_MATIERE" ),
		@JoinColumn(name="NOM_MATIERE",referencedColumnName="NOM_MATIERE")})
	private Matiere matiere ;
	 
	public Long getIdAffect() {
		return idAffect;
	}
	public void setIdAffect(Long idAffect) {
		this.idAffect = idAffect;
	}
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
		
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
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public String getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	

}
