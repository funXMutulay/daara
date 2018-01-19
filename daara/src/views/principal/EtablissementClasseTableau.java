package views.principal;

import javafx.beans.property.SimpleStringProperty;

public class EtablissementClasseTableau {
	private final SimpleStringProperty etablissementClasseTableauNom ;
	private final SimpleStringProperty etablissementClasseTableauPrenom ;
	private final SimpleStringProperty etablissementClasseTableauAdresse ;
	private final SimpleStringProperty etablissementClasseTableauEmail ;
	private final SimpleStringProperty etablissementClasseTableauClasse ;
	private final SimpleStringProperty etablissementClasseTableauTuteur ;
	
	
	
	
	
	public EtablissementClasseTableau(String etablissementClasseTableauNom,
			String etablissementClasseTableauPrenom,
			String etablissementClasseTableauAdresse,
			String etablissementClasseTableauEmail,
			String etablissementClasseTableauClasse,
			String etablissementClasseTableauTuteur) 
	{
		
		this.etablissementClasseTableauNom = new SimpleStringProperty (etablissementClasseTableauNom) ;
		this.etablissementClasseTableauPrenom = new SimpleStringProperty(etablissementClasseTableauPrenom);
		this.etablissementClasseTableauAdresse = new SimpleStringProperty(etablissementClasseTableauAdresse);
		this.etablissementClasseTableauEmail = new SimpleStringProperty(etablissementClasseTableauEmail);
		this.etablissementClasseTableauClasse = new SimpleStringProperty(etablissementClasseTableauClasse);
		this.etablissementClasseTableauTuteur = new SimpleStringProperty(etablissementClasseTableauTuteur);
	}

	public final SimpleStringProperty etablissementClasseTableauNomProperty() {
		return this.etablissementClasseTableauNom;
	}
	
	public final String getetablissementClasseTableauNom() {
		return this.etablissementClasseTableauNomProperty().get();
	}
	
	public final void setetablissementClasseTableauNom(final String etablissementClasseTableauNom) {
		this.etablissementClasseTableauNomProperty().set(etablissementClasseTableauNom);
	}
	
	public final SimpleStringProperty EtablissementClasseTableauPrenomProperty() {
		return this.etablissementClasseTableauPrenom;
	}
	
	public final String getEtablissementClasseTableauPrenom() {
		return this.EtablissementClasseTableauPrenomProperty().get();
	}
	
	public final void setEtablissementClasseTableauPrenom(final String etablissementClasseTableauPrenom) {
		this.EtablissementClasseTableauPrenomProperty().set(etablissementClasseTableauPrenom);
	}
	
	public final SimpleStringProperty etablissementClasseTableauAdresseProperty() {
		return this.etablissementClasseTableauAdresse;
	}
	
	public final String getEtablissementClasseTableauAdresse() {
		return this.etablissementClasseTableauAdresseProperty().get();
	}
	
	public final void setEtablissementClasseTableauAdresse(final String etablissementClasseTableauAdresse) {
		this.etablissementClasseTableauAdresseProperty().set(etablissementClasseTableauAdresse);
	}
	
	public final SimpleStringProperty etablissementClasseTableauEmailProperty() {
		return this.etablissementClasseTableauEmail;
	}
	
	public final String getEtablissementClasseTableauEmail() {
		return this.etablissementClasseTableauEmailProperty().get();
	}
	
	public final void setEtablissementClasseTableauEmail(final String etablissementClasseTableauEmail) {
		this.etablissementClasseTableauEmailProperty().set(etablissementClasseTableauEmail);
	}
	
	public final SimpleStringProperty EtablissementClasseTableauClasseProperty() {
		return this.etablissementClasseTableauClasse;
	}
	
	public final String getEtablissementClasseTableauClasse() {
		return this.EtablissementClasseTableauClasseProperty().get();
	}
	
	public final void setEtablissementClasseTableauClasse(final String etablissementClasseTableauClasse) {
		this.EtablissementClasseTableauClasseProperty().set(etablissementClasseTableauClasse);
	}
	
	public final SimpleStringProperty EtablissementClasseTableauTuteurProperty() {
		return this.etablissementClasseTableauTuteur;
	}
	
	public final String getEtablissementClasseTableauTuteur() {
		return this.EtablissementClasseTableauTuteurProperty().get();
	}
	
	public final void setEtablissementClasseTableauTuteur(final String EtablissementClasseTableauTuteur) {
		this.EtablissementClasseTableauTuteurProperty().set(EtablissementClasseTableauTuteur);
	}
		
}


