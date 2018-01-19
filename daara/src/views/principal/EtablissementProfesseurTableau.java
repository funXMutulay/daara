package views.principal;

import javafx.beans.property.SimpleStringProperty;

public class EtablissementProfesseurTableau {
	
	private final SimpleStringProperty etablissementProfesseurTableauNom ;
	private final SimpleStringProperty etablissementProfesseurTableauPrenom ;
	private final SimpleStringProperty etablissementProfesseurTableauAdresse ;
	private final SimpleStringProperty etablissementProfesseurTableauEmail ;
	private final SimpleStringProperty etablissementProfesseurTableauNumTel ;
	
	
	
	
	
	
	public EtablissementProfesseurTableau(String etablissementProfesseurTableauNom,
			String etablissementProfesseurTableauPrenom,
			String etablissementProfesseurTableauAdresse,
			String etablissementProfesseurTableauEmail,
			String etablissementProfesseurTableauNumTel) 
	{
		
		this.etablissementProfesseurTableauNom = new SimpleStringProperty (etablissementProfesseurTableauNom) ;
		this.etablissementProfesseurTableauPrenom = new SimpleStringProperty(etablissementProfesseurTableauPrenom);
		this.etablissementProfesseurTableauAdresse = new SimpleStringProperty(etablissementProfesseurTableauAdresse);
		this.etablissementProfesseurTableauEmail = new SimpleStringProperty(etablissementProfesseurTableauEmail);
		this.etablissementProfesseurTableauNumTel= new SimpleStringProperty(etablissementProfesseurTableauNumTel);
		
	}

	public final SimpleStringProperty etablissementProfesseurTableauNomProperty() {
		return this.etablissementProfesseurTableauNom;
	}
	
	public final String getEtablissementProfesseurTableauNom() {
		return this.etablissementProfesseurTableauNomProperty().get();
	}
	
	public final void setEtablissementProfesseurTableauNom(final String etablissementProfesseurTableauNom) {
		this.etablissementProfesseurTableauNomProperty().set(etablissementProfesseurTableauNom);
	}
	
	public final SimpleStringProperty etablissementProfesseurTableauPrenomProperty() {
		return this.etablissementProfesseurTableauPrenom;
	}
	
	public final String getEtablissementProfesseurTableauPrenom() {
		return this.etablissementProfesseurTableauPrenomProperty().get();
	}
	
	public final void setEtablissementProfesseurTableauPrenom(final String etablissementProfesseurTableauPrenom) {
		this.etablissementProfesseurTableauPrenomProperty().set(etablissementProfesseurTableauPrenom);
	}
	
	public final SimpleStringProperty etablissementProfesseurTableauAdresseProperty() {
		return this.etablissementProfesseurTableauAdresse;
	}
	
	public final String getEtablissementProfesseurTableauAdresse() {
		return this.etablissementProfesseurTableauAdresseProperty().get();
	}
	
	public final void setEtablissementProfesseurTableauAdresse(final String etablissementProfesseurTableauAdresse) {
		this.etablissementProfesseurTableauAdresseProperty().set(etablissementProfesseurTableauAdresse);
	}
	
	public final SimpleStringProperty etablissementProfesseurTableauEmailProperty() {
		return this.etablissementProfesseurTableauEmail;
	}
	
	public final String getEtablissementProfesseurTableauEmail() {
		return this.etablissementProfesseurTableauEmailProperty().get();
	}
	
	public final void setEtablissementProfesseurTableauEmail(final String etablissementProfesseurTableauEmail) {
		this.etablissementProfesseurTableauEmailProperty().set(etablissementProfesseurTableauEmail);
	}
	
	public final SimpleStringProperty etablissementProfesseurTableauNumTelProperty() {
		return this.etablissementProfesseurTableauNumTel;
	}
	
	public final String getEtablissementProfesseurTableauNumTel() {
		return this.etablissementProfesseurTableauNumTelProperty().get();
	}
	
	public final void setEtablissementProfesseurTableauNumTel(final String etablissementProfesseurTableauNumTel) {
		this.etablissementProfesseurTableauNumTelProperty().set(etablissementProfesseurTableauNumTel);
	}
	
	
	


}
