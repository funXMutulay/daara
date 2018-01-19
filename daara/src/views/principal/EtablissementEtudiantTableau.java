package views.principal;

import javafx.beans.property.SimpleStringProperty;

public class EtablissementEtudiantTableau {

	private final SimpleStringProperty etablissementEtudiantTableauNom ;
	private final SimpleStringProperty etablissementEtudiantTableauPrenom ;
	private final SimpleStringProperty etablissementEtudiantTableauAdresse ;
	private final SimpleStringProperty etablissementEtudiantTableauEmail ;
	private final SimpleStringProperty etablissementEtudiantTableauClasse ;
	private final SimpleStringProperty etablissementEtudiantTableauTuteur ;
	
	
	
	
	
	public EtablissementEtudiantTableau(String etablissementEtudiantTableauNom,
			String etablissementEtudiantTableauPrenom,
			String etablissementEtudiantTableauAdresse,
			String etablissementEtudiantTableauEmail,
			String etablissementEtudiantTableauClasse,
			String etablissementEtudiantTableauTuteur) 
	{
		
		this.etablissementEtudiantTableauNom = new SimpleStringProperty (etablissementEtudiantTableauNom) ;
		this.etablissementEtudiantTableauPrenom = new SimpleStringProperty(etablissementEtudiantTableauPrenom);
		this.etablissementEtudiantTableauAdresse = new SimpleStringProperty(etablissementEtudiantTableauAdresse);
		this.etablissementEtudiantTableauEmail = new SimpleStringProperty(etablissementEtudiantTableauEmail);
		this.etablissementEtudiantTableauClasse = new SimpleStringProperty(etablissementEtudiantTableauClasse);
		this.etablissementEtudiantTableauTuteur = new SimpleStringProperty(etablissementEtudiantTableauTuteur);
	}

	public final SimpleStringProperty etablissementEtudiantTableauNomProperty() {
		return this.etablissementEtudiantTableauNom;
	}
	
	public final String getEtablissementEtudiantTableauNom() {
		return this.etablissementEtudiantTableauNomProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauNom(final String etablissementEtudiantTableauNom) {
		this.etablissementEtudiantTableauNomProperty().set(etablissementEtudiantTableauNom);
	}
	
	public final SimpleStringProperty etablissementEtudiantTableauPrenomProperty() {
		return this.etablissementEtudiantTableauPrenom;
	}
	
	public final String getEtablissementEtudiantTableauPrenom() {
		return this.etablissementEtudiantTableauPrenomProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauPrenom(final String etablissementEtudiantTableauPrenom) {
		this.etablissementEtudiantTableauPrenomProperty().set(etablissementEtudiantTableauPrenom);
	}
	
	public final SimpleStringProperty etablissementEtudiantTableauAdresseProperty() {
		return this.etablissementEtudiantTableauAdresse;
	}
	
	public final String getEtablissementEtudiantTableauAdresse() {
		return this.etablissementEtudiantTableauAdresseProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauAdresse(final String etablissementEtudiantTableauAdresse) {
		this.etablissementEtudiantTableauAdresseProperty().set(etablissementEtudiantTableauAdresse);
	}
	
	public final SimpleStringProperty etablissementEtudiantTableauEmailProperty() {
		return this.etablissementEtudiantTableauEmail;
	}
	
	public final String getEtablissementEtudiantTableauEmail() {
		return this.etablissementEtudiantTableauEmailProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauEmail(final String etablissementEtudiantTableauEmail) {
		this.etablissementEtudiantTableauEmailProperty().set(etablissementEtudiantTableauEmail);
	}
	
	public final SimpleStringProperty etablissementEtudiantTableauClasseProperty() {
		return this.etablissementEtudiantTableauClasse;
	}
	
	public final String getEtablissementEtudiantTableauClasse() {
		return this.etablissementEtudiantTableauClasseProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauClasse(final String etablissementEtudiantTableauClasse) {
		this.etablissementEtudiantTableauClasseProperty().set(etablissementEtudiantTableauClasse);
	}
	
	public final SimpleStringProperty etablissementEtudiantTableauTuteurProperty() {
		return this.etablissementEtudiantTableauTuteur;
	}
	
	public final String getEtablissementEtudiantTableauTuteur() {
		return this.etablissementEtudiantTableauTuteurProperty().get();
	}
	
	public final void setEtablissementEtudiantTableauTuteur(final String etablissementEtudiantTableauTuteur) {
		this.etablissementEtudiantTableauTuteurProperty().set(etablissementEtudiantTableauTuteur);
	}
		
}
