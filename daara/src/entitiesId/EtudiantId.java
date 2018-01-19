package entitiesId;

import java.io.Serializable;

public class EtudiantId implements Serializable{

	private String nom ;
	private String prenom;
	private String email ;
	
	public EtudiantId(){
		
	}
	public EtudiantId(String nom , String prenom , String email){
		this.nom = nom ;
		this.prenom = prenom ;
		this.email = email ;
		
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	
	
}
