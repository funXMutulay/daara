package views.professur;

import javafx.beans.property.SimpleStringProperty;

public class ProfesseurEtudiantTableau {
	private final SimpleStringProperty professeurEtudiantTableauNom ;
	private final SimpleStringProperty professeurEtudiantTableauPrenom ;
	private final SimpleStringProperty professeurEtudiantTableauAdresse ;
	private final SimpleStringProperty professeurEtudiantTableauEmail ;
	private final SimpleStringProperty professeurEtudiantTableauClasse ;
	private final SimpleStringProperty professeurEtudiantTableauTuteur ;
	
	
	
	
	
	public ProfesseurEtudiantTableau(String professeurEtudiantTableauNom,
			String professeurEtudiantTableauPrenom,
			String professeurEtudiantTableauAdresse,
			String professeurEtudiantTableauEmail,
			String professeurEtudiantTableauClasse,
			String professeurEtudiantTableauTuteur) 
	{
		
		this.professeurEtudiantTableauNom = new SimpleStringProperty (professeurEtudiantTableauNom) ;
		this.professeurEtudiantTableauPrenom = new SimpleStringProperty(professeurEtudiantTableauPrenom);
		this.professeurEtudiantTableauAdresse = new SimpleStringProperty(professeurEtudiantTableauAdresse);
		this.professeurEtudiantTableauEmail = new SimpleStringProperty(professeurEtudiantTableauEmail);
		this.professeurEtudiantTableauClasse = new SimpleStringProperty(professeurEtudiantTableauClasse);
		this.professeurEtudiantTableauTuteur = new SimpleStringProperty(professeurEtudiantTableauTuteur);
	}

	public final SimpleStringProperty professeurEtudiantTableauNomProperty() {
		return this.professeurEtudiantTableauNom;
	}
	
	public final String getProfesseurEtudiantTableauNom() {
		return this.professeurEtudiantTableauNomProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauNom(final String professeurEtudiantTableauNom) {
		this.professeurEtudiantTableauNomProperty().set(professeurEtudiantTableauNom);
	}
	
	public final SimpleStringProperty professeurEtudiantTableauPrenomProperty() {
		return this.professeurEtudiantTableauPrenom;
	}
	
	public final String getProfesseurEtudiantTableauPrenom() {
		return this.professeurEtudiantTableauPrenomProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauPrenom(final String professeurEtudiantTableauPrenom) {
		this.professeurEtudiantTableauPrenomProperty().set(professeurEtudiantTableauPrenom);
	}
	
	public final SimpleStringProperty professeurEtudiantTableauAdresseProperty() {
		return this.professeurEtudiantTableauAdresse;
	}
	
	public final String getProfesseurEtudiantTableauAdresse() {
		return this.professeurEtudiantTableauAdresseProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauAdresse(final String professeurEtudiantTableauAdresse) {
		this.professeurEtudiantTableauAdresseProperty().set(professeurEtudiantTableauAdresse);
	}
	
	public final SimpleStringProperty professeurEtudiantTableauEmailProperty() {
		return this.professeurEtudiantTableauEmail;
	}
	
	public final String getProfesseurEtudiantTableauEmail() {
		return this.professeurEtudiantTableauEmailProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauEmail(final String professeurEtudiantTableauEmail) {
		this.professeurEtudiantTableauEmailProperty().set(professeurEtudiantTableauEmail);
	}
	
	public final SimpleStringProperty professeurEtudiantTableauClasseProperty() {
		return this.professeurEtudiantTableauClasse;
	}
	
	public final String getProfesseurEtudiantTableauClasse() {
		return this.professeurEtudiantTableauClasseProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauClasse(final String professeurEtudiantTableauClasse) {
		this.professeurEtudiantTableauClasseProperty().set(professeurEtudiantTableauClasse);
	}
	
	public final SimpleStringProperty professeurEtudiantTableauTuteurProperty() {
		return this.professeurEtudiantTableauTuteur;
	}
	
	public final String getProfesseurEtudiantTableauTuteur() {
		return this.professeurEtudiantTableauTuteurProperty().get();
	}
	
	public final void setProfesseurEtudiantTableauTuteur(final String professeurEtudiantTableauTuteur) {
		this.professeurEtudiantTableauTuteurProperty().set(professeurEtudiantTableauTuteur);
	}
		

}
