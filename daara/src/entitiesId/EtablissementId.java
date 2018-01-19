package entitiesId;

import java.io.Serializable;

public class EtablissementId implements Serializable{
	
	private Long idEtablissement ;
	
	private String nom ;
	
	public EtablissementId(){
		
							}
	
	
	public EtablissementId(Long idEtablissement, String nom) {
		super();
		this.idEtablissement = idEtablissement;
		this.nom = nom;
	}
	public Long getIdEtablissement() {
		return idEtablissement;
	}
	public String getNom() {
		return nom;
	}
	
	

}
