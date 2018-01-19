package org.ninthQuantum.daara.generator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.ninthQuantum.daara.entities.Etudiant;
import org.ninthQuantum.daara.entities.Matiere;
/*
 * Created By Mamadou Kébé
 */
@Entity
public class Semestre {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SEMESTRE")
	private Long idSemestre ;
	
	@Column(name="NOM")
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="ID_NOTATION")
	private Notation notation ;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn (name="NOM_ETUDIANT",referencedColumnName="NOM_ETUDIANT") 
		,@JoinColumn (name="PRENOM_ETUDIANT",referencedColumnName="PRENOM_ETUDIANT")
		,@JoinColumn (name="EMAIL_ETUDIANT",referencedColumnName="EMAIL_ETUDIANT")
		
		})
	private Etudiant etudiant;
	
	@ElementCollection
	private List <Integer> controleContinu= new ArrayList<Integer>();
	
	@Column(name="COMP")
	private Integer comp ;
	
	@Column(name="MOYENNE_GENERALE")
	private Integer moyGen ;
	
	
	
	public Long getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Notation getNotation() {
		return notation;
	}
	public void setNotation(Notation notation) {
		this.notation = notation;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public List<Integer> getControleContinu() {
		return controleContinu;
	}
	public void setControleContinu(List<Integer> controleContinu) {
		this.controleContinu = controleContinu;
	}
	public Integer getComp() {
		return comp;
	}
	public void setComp(Integer comp) {
		this.comp = comp;
	}
	public Integer getMoyGen() {
		return moyGen;
	}
	public void setMoyGen(Integer moyGen) {
		this.moyGen = moyGen;
	}
	
	
	
	
}
