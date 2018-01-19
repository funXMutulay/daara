package org.ninthQuantum.daara.generator;

import java.awt.TextArea;
import java.util.Date;

import org.ninthQuantum.daara.entities.Etudiant;
import org.ninthQuantum.daara.entities.Tuteur;

public class Notification {
	
	private Long idNotif ;
	private Date dateOfNotif = new Date();
	private Etudiant etudNotif ;
	private Tuteur tutNotif ;
	private TextArea corpsNotif ;

	
	public Long getIdNotif() {
		return idNotif;
	}
	public void setIdNotif(Long idNotif) {
		this.idNotif = idNotif;
	}
	public Date getDateOfNotif() {
		return dateOfNotif;
	}
	public void setDateOfNotif(Date dateOfNotif) {
		this.dateOfNotif = dateOfNotif;
	}
	public Etudiant getEtudNotif() {
		return etudNotif;
	}
	public void setEtudNotif(Etudiant etudNotif) {
		this.etudNotif = etudNotif;
	}
	public Tuteur getTutNotif() {
		return tutNotif;
	}
	public void setTutNotif(Tuteur tutNotif) {
		this.tutNotif = tutNotif;
	}
	public TextArea getCorpsNotif() {
		return corpsNotif;
	}
	public void setCorpsNotif(TextArea corpsNotif) {
		this.corpsNotif = corpsNotif;
	}
	
}
