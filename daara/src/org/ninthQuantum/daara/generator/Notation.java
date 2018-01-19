package org.ninthQuantum.daara.generator;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Notation {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_NOTATION")
	private Long idNota ;
	
	@ManyToOne
	@JoinColumn (name="ID_AFFECTATION_PROFESSEUR")
	private AffectationProfesseur affectProf ;
	
	@ElementCollection
	@OneToMany
	@JoinColumn(name="ID_SEMESTRE")
	private Collection<Semestre>  listEtudiantSemestre = new ArrayList<Semestre>();
	
	public Long getIdNota() {
		return idNota;
	}
	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}
	
	public AffectationProfesseur getAffectProf() {
		return affectProf;
	}
	public void setAffectProf(AffectationProfesseur affectProf) {
		this.affectProf = affectProf;
	}
	public Collection<Semestre> getListEtudiantSemestre() {
		return listEtudiantSemestre;
	}
	public void setListEtudiantSemestre(Collection<Semestre> listEtudiantSemestre) {
		this.listEtudiantSemestre = listEtudiantSemestre;
	}
	
	
	

}
