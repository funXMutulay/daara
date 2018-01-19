package views.professur;

import javafx.beans.property.SimpleStringProperty;

public class ProfesseurClasseTableau {
	private final SimpleStringProperty professeurClasseTableauNom ;
	private final SimpleStringProperty professeurClasseTableauPrenom ;
	private final SimpleStringProperty professeurClasseTableauAdresse ;
	private final SimpleStringProperty professeurClasseTableauEmail ;
	private final SimpleStringProperty professeurClasseTableauClasse ;
	private final SimpleStringProperty professeurClasseTableauTuteur ;
	
	
	
	
	
	public ProfesseurClasseTableau(String professeurClasseTableauNom,
			String professeurClasseTableauPrenom,
			String professeurClasseTableauAdresse,
			String professeurClasseTableauEmail,
			String professeurClasseTableauClasse,
			String professeurClasseTableauTuteur) 
	{
		
		this.professeurClasseTableauNom = new SimpleStringProperty (professeurClasseTableauNom) ;
		this.professeurClasseTableauPrenom = new SimpleStringProperty(professeurClasseTableauPrenom);
		this.professeurClasseTableauAdresse = new SimpleStringProperty(professeurClasseTableauAdresse);
		this.professeurClasseTableauEmail = new SimpleStringProperty(professeurClasseTableauEmail);
		this.professeurClasseTableauClasse = new SimpleStringProperty(professeurClasseTableauClasse);
		this.professeurClasseTableauTuteur = new SimpleStringProperty(professeurClasseTableauTuteur);
	}

	public final SimpleStringProperty professeurClasseTableauNomProperty() {
		return this.professeurClasseTableauNom;
	}
	
	public final String getProfesseurClasseTableauNom() {
		return this.professeurClasseTableauNomProperty().get();
	}
	
	public final void setProfesseurClasseTableauNom(final String professeurClasseTableauNom) {
		this.professeurClasseTableauNomProperty().set(professeurClasseTableauNom);
	}
	
	public final SimpleStringProperty professeurClasseTableauPrenomProperty() {
		return this.professeurClasseTableauPrenom;
	}
	
	public final String getProfesseurClasseTableauPrenom() {
		return this.professeurClasseTableauPrenomProperty().get();
	}
	
	public final void setProfesseurClasseTableauPrenom(final String professeurClasseTableauPrenom) {
		this.professeurClasseTableauPrenomProperty().set(professeurClasseTableauPrenom);
	}
	
	public final SimpleStringProperty professeurClasseTableauAdresseProperty() {
		return this.professeurClasseTableauAdresse;
	}
	
	public final String getProfesseurClasseTableauAdresse() {
		return this.professeurClasseTableauAdresseProperty().get();
	}
	
	public final void setProfesseurClasseTableauAdresse(final String professeurClasseTableauAdresse) {
		this.professeurClasseTableauAdresseProperty().set(professeurClasseTableauAdresse);
	}
	
	public final SimpleStringProperty professeurClasseTableauEmailProperty() {
		return this.professeurClasseTableauEmail;
	}
	
	public final String getProfesseurClasseTableauEmail() {
		return this.professeurClasseTableauEmailProperty().get();
	}
	
	public final void setProfesseurClasseTableauEmail(final String professeurClasseTableauEmail) {
		this.professeurClasseTableauEmailProperty().set(professeurClasseTableauEmail);
	}
	
	public final SimpleStringProperty professeurClasseTableauClasseProperty() {
		return this.professeurClasseTableauClasse;
	}
	
	public final String getProfesseurClasseTableauClasse() {
		return this.professeurClasseTableauClasseProperty().get();
	}
	
	public final void setProfesseurClasseTableauClasse(final String professeurClasseTableauClasse) {
		this.professeurClasseTableauClasseProperty().set(professeurClasseTableauClasse);
	}
	
	public final SimpleStringProperty ProfesseurClasseTableauTuteurProperty() {
		return this.professeurClasseTableauTuteur;
	}
	
	public final String getProfesseurClasseTableauTuteur() {
		return this.ProfesseurClasseTableauTuteurProperty().get();
	}
	
	public final void setProfesseurClasseTableauTuteur(final String professeurClasseTableauTuteur) {
		this.ProfesseurClasseTableauTuteurProperty().set(professeurClasseTableauTuteur);
	}
		

}
