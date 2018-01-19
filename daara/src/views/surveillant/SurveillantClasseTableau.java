package views.surveillant;

import javafx.beans.property.SimpleStringProperty;

public class SurveillantClasseTableau {
	private final SimpleStringProperty surveillantClasseTableauNom ;
	private final SimpleStringProperty surveillantClasseTableauPrenom ;
	private final SimpleStringProperty surveillantClasseTableauAdresse ;
	private final SimpleStringProperty surveillantClasseTableauEmail ;
	private final SimpleStringProperty surveillantClasseTableauClasse ;
	private final SimpleStringProperty SurveillantClasseTableauTuteur ;
	
	
	
	
	
	public SurveillantClasseTableau(String surveillantClasseTableauNom,
			String surveillantClasseTableauPrenom,
			String surveillantClasseTableauAdresse,
			String surveillantClasseTableauEmail,
			String surveillantClasseTableauClasse,
			String surveillantClasseTableauTuteur) 
	{
		
		this.surveillantClasseTableauNom = new SimpleStringProperty (surveillantClasseTableauNom) ;
		this.surveillantClasseTableauPrenom = new SimpleStringProperty(surveillantClasseTableauPrenom);
		this.surveillantClasseTableauAdresse = new SimpleStringProperty(surveillantClasseTableauAdresse);
		this.surveillantClasseTableauEmail = new SimpleStringProperty(surveillantClasseTableauEmail);
		this.surveillantClasseTableauClasse = new SimpleStringProperty(surveillantClasseTableauClasse);
		this.SurveillantClasseTableauTuteur = new SimpleStringProperty(surveillantClasseTableauTuteur);
	}

	public final SimpleStringProperty surveillantClasseTableauNomProperty() {
		return this.surveillantClasseTableauNom;
	}
	
	public final String getSurveillantClasseTableauNom() {
		return this.surveillantClasseTableauNomProperty().get();
	}
	
	public final void setSurveillantClasseTableauNom(final String surveillantClasseTableauNom) {
		this.surveillantClasseTableauNomProperty().set(surveillantClasseTableauNom);
	}
	
	public final SimpleStringProperty surveillantClasseTableauPrenomProperty() {
		return this.surveillantClasseTableauPrenom;
	}
	
	public final String getSurveillantClasseTableauPrenom() {
		return this.surveillantClasseTableauPrenomProperty().get();
	}
	
	public final void setSurveillantClasseTableauPrenom(final String surveillantClasseTableauPrenom) {
		this.surveillantClasseTableauPrenomProperty().set(surveillantClasseTableauPrenom);
	}
	
	public final SimpleStringProperty surveillantClasseTableauAdresseProperty() {
		return this.surveillantClasseTableauAdresse;
	}
	
	public final String getSurveillantClasseTableauAdresse() {
		return this.surveillantClasseTableauAdresseProperty().get();
	}
	
	public final void setSurveillantClasseTableauAdresse(final String surveillantClasseTableauAdresse) {
		this.surveillantClasseTableauAdresseProperty().set(surveillantClasseTableauAdresse);
	}
	
	public final SimpleStringProperty surveillantClasseTableauEmailProperty() {
		return this.surveillantClasseTableauEmail;
	}
	
	public final String getSurveillantClasseTableauEmail() {
		return this.surveillantClasseTableauEmailProperty().get();
	}
	
	public final void setSurveillantClasseTableauEmail(final String surveillantClasseTableauEmail) {
		this.surveillantClasseTableauEmailProperty().set(surveillantClasseTableauEmail);
	}
	
	public final SimpleStringProperty surveillantClasseTableauClasseProperty() {
		return this.surveillantClasseTableauClasse;
	}
	
	public final String getSurveillantClasseTableauClasse() {
		return this.surveillantClasseTableauClasseProperty().get();
	}
	
	public final void setSurveillantClasseTableauClasse(final String surveillantClasseTableauClasse) {
		this.surveillantClasseTableauClasseProperty().set(surveillantClasseTableauClasse);
	}
	
	public final SimpleStringProperty SurveillantClasseTableauTuteurProperty() {
		return this.SurveillantClasseTableauTuteur;
	}
	
	public final String getSurveillantClasseTableauTuteur() {
		return this.SurveillantClasseTableauTuteurProperty().get();
	}
	
	public final void setSurveillantClasseTableauTuteur(final String SurveillantClasseTableauTuteur) {
		this.SurveillantClasseTableauTuteurProperty().set(SurveillantClasseTableauTuteur);
	}
		

}
