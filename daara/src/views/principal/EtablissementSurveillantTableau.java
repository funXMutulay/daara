package views.principal;

import javafx.beans.property.SimpleStringProperty;

public class EtablissementSurveillantTableau {
	
	private final SimpleStringProperty etablissementSurveillantTableauNom ;
	private final SimpleStringProperty etablissementSurveillantTableauPrenom ;
	private final SimpleStringProperty etablissementSurveillantTableauAdresse ;
	private final SimpleStringProperty etablissementSurveillantTableauEmail ;
	private final SimpleStringProperty etablissementSurveillantTableauNumTel ;
	
	
	
	
	
	public EtablissementSurveillantTableau(String etablissementSurveillantTableauNom,
			String etablissementSurveillantTableauPrenom,
			String etablissementSurveillantTableauAdresse,
			String etablissementSurveillantTableauEmail,
			String etablissementSurveillantTableauNumTel) 
	{
		
		this.etablissementSurveillantTableauNom = new SimpleStringProperty (etablissementSurveillantTableauNom) ;
		this.etablissementSurveillantTableauPrenom = new SimpleStringProperty(etablissementSurveillantTableauPrenom);
		this.etablissementSurveillantTableauAdresse = new SimpleStringProperty(etablissementSurveillantTableauAdresse);
		this.etablissementSurveillantTableauEmail = new SimpleStringProperty(etablissementSurveillantTableauEmail);
		this.etablissementSurveillantTableauNumTel = new SimpleStringProperty(etablissementSurveillantTableauNumTel);
	}

	public final SimpleStringProperty etablissementSurveillantTableauNomProperty() {
		return this.etablissementSurveillantTableauNom;
	}
	
	public final String getEtablissementSurveillantTableauNom() {
		return this.etablissementSurveillantTableauNomProperty().get();
	}
	
	public final void setEtablissementSurveillantTableauNom(final String etablissementSurveillantTableauNom) {
		this.etablissementSurveillantTableauNomProperty().set(etablissementSurveillantTableauNom);
	}
	
	public final SimpleStringProperty etablissementSurveillantTableauPrenomProperty() {
		return this.etablissementSurveillantTableauPrenom;
	}
	
	public final String getEtablissementSurveillantTableauPrenom() {
		return this.etablissementSurveillantTableauPrenomProperty().get();
	}
	
	public final void setEtablissementSurveillantTableauPrenom(final String etablissementSurveillantTableauPrenom) {
		this.etablissementSurveillantTableauPrenomProperty().set(etablissementSurveillantTableauPrenom);
	}
	
	public final SimpleStringProperty etablissementSurveillantTableauAdresseProperty() {
		return this.etablissementSurveillantTableauAdresse;
	}
	
	public final String getEtablissementSurveillantTableauAdresse() {
		return this.etablissementSurveillantTableauAdresseProperty().get();
	}
	
	public final void setEtablissementSurveillantTableauAdresse(final String etablissementSurveillantTableauAdresse) {
		this.etablissementSurveillantTableauAdresseProperty().set(etablissementSurveillantTableauAdresse);
	}
	
	public final SimpleStringProperty etablissementSurveillantTableauEmailProperty() {
		return this.etablissementSurveillantTableauEmail;
	}
	
	public final String getEtablissementSurveillantTableauEmail() {
		return this.etablissementSurveillantTableauEmailProperty().get();
	}
	
	public final void setEtablissementSurveillantTableauEmail(final String etablissementSurveillantTableauEmail) {
		this.etablissementSurveillantTableauEmailProperty().set(etablissementSurveillantTableauEmail);
	}
	
	public final SimpleStringProperty etablissementSurveillantTableauNumTelProperty() {
		return this.etablissementSurveillantTableauNumTel;
	}
	
	public final String getEtablissementSurveillantTableauNumTel() {
		return this.etablissementSurveillantTableauNumTelProperty().get();
	}
	
	public final void setEtablissementSurveillantTableauNumTel(final String etablissementSurveillantTableauNumTel) {
		this.etablissementSurveillantTableauNumTelProperty().set(etablissementSurveillantTableauNumTel);
	}
	
	
	

}
