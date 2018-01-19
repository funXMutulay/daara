package views.surveillant;

import javafx.beans.property.SimpleStringProperty;

public class SurveillantEtudiantTableau {
	private final SimpleStringProperty surveillantEtudiantTableauNom ;
	private final SimpleStringProperty surveillantEtudiantTableauPrenom ;
	private final SimpleStringProperty surveillantEtudiantTableauAdresse ;
	private final SimpleStringProperty surveillantEtudiantTableauEmail ;
	private final SimpleStringProperty surveillantEtudiantTableauClasse ;
	private final SimpleStringProperty surveillantEtudiantTableauTuteur ;
	
	
	
	
	
	public SurveillantEtudiantTableau(String surveillantEtudiantTableauNom,
			String surveillantEtudiantTableauPrenom,
			String surveillantEtudiantTableauAdresse,
			String surveillantEtudiantTableauEmail,
			String surveillantEtudiantTableauClasse,
			String surveillantEtudiantTableauTuteur) 
	{
		
		this.surveillantEtudiantTableauNom = new SimpleStringProperty (surveillantEtudiantTableauNom) ;
		this.surveillantEtudiantTableauPrenom = new SimpleStringProperty(surveillantEtudiantTableauPrenom);
		this.surveillantEtudiantTableauAdresse = new SimpleStringProperty(surveillantEtudiantTableauAdresse);
		this.surveillantEtudiantTableauEmail = new SimpleStringProperty(surveillantEtudiantTableauEmail);
		this.surveillantEtudiantTableauClasse = new SimpleStringProperty(surveillantEtudiantTableauClasse);
		this.surveillantEtudiantTableauTuteur = new SimpleStringProperty(surveillantEtudiantTableauTuteur);
	}

	public final SimpleStringProperty surveillantEtudiantTableauNomProperty() {
		return this.surveillantEtudiantTableauNom;
	}
	
	public final String getSurveillantEtudiantTableauNom() {
		return this.surveillantEtudiantTableauNomProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauNom(final String surveillantEtudiantTableauNom) {
		this.surveillantEtudiantTableauNomProperty().set(surveillantEtudiantTableauNom);
	}
	
	public final SimpleStringProperty surveillantEtudiantTableauPrenomProperty() {
		return this.surveillantEtudiantTableauPrenom;
	}
	
	public final String getSurveillantEtudiantTableauPrenom() {
		return this.surveillantEtudiantTableauPrenomProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauPrenom(final String surveillantEtudiantTableauPrenom) {
		this.surveillantEtudiantTableauPrenomProperty().set(surveillantEtudiantTableauPrenom);
	}
	
	public final SimpleStringProperty surveillantEtudiantTableauAdresseProperty() {
		return this.surveillantEtudiantTableauAdresse;
	}
	
	public final String getSurveillantEtudiantTableauAdresse() {
		return this.surveillantEtudiantTableauAdresseProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauAdresse(final String surveillantEtudiantTableauAdresse) {
		this.surveillantEtudiantTableauAdresseProperty().set(surveillantEtudiantTableauAdresse);
	}
	
	public final SimpleStringProperty surveillantEtudiantTableauEmailProperty() {
		return this.surveillantEtudiantTableauEmail;
	}
	
	public final String getSurveillantEtudiantTableauEmail() {
		return this.surveillantEtudiantTableauEmailProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauEmail(final String surveillantEtudiantTableauEmail) {
		this.surveillantEtudiantTableauEmailProperty().set(surveillantEtudiantTableauEmail);
	}
	
	public final SimpleStringProperty surveillantEtudiantTableauClasseProperty() {
		return this.surveillantEtudiantTableauClasse;
	}
	
	public final String getSurveillantEtudiantTableauClasse() {
		return this.surveillantEtudiantTableauClasseProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauClasse(final String surveillantEtudiantTableauClasse) {
		this.surveillantEtudiantTableauClasseProperty().set(surveillantEtudiantTableauClasse);
	}
	
	public final SimpleStringProperty surveillantEtudiantTableauTuteurProperty() {
		return this.surveillantEtudiantTableauTuteur;
	}
	
	public final String getSurveillantEtudiantTableauTuteur() {
		return this.surveillantEtudiantTableauTuteurProperty().get();
	}
	
	public final void setSurveillantEtudiantTableauTuteur(final String surveillantEtudiantTableauTuteur) {
		this.surveillantEtudiantTableauTuteurProperty().set(surveillantEtudiantTableauTuteur);
	}
		

}
