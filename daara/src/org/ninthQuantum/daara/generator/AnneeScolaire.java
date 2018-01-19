package org.ninthQuantum.daara.generator;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnneeScolaire {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ANNEE_SCOLAIRE")
	private Long idAnneeScolaire;
	@Column(name="DATE_OUVERTURE")
	private Date dateOuverture ;
	@Column(name="DATE_FERMETURE")
	private Date dateFermeture ;
	
	@Column(name="ANNEE_SCOLAIRE")
	private String anneeScolaire ;
	
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public Date getDateFermeture() {
		return dateFermeture;
	}
	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
	public String getAnneeScolaire() {
		
		return anneeScolaire;
	}
	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	public AnneeScolaire(Date dateOuverture, Date dateFermeture, String anneeScolaire) {
		super();
		this.dateOuverture = dateOuverture;
		this.dateFermeture = dateFermeture;
		this.anneeScolaire = anneeScolaire;
	}
	

}
