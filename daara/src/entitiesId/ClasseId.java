package entitiesId;

import java.io.Serializable;

public class ClasseId implements Serializable{

	public ClasseId(){
		
	}
	
	public ClasseId(String niveau , String variance){
	
		this.niveau = niveau ;
		this.variance = variance ;
	}
	
	
	private String niveau;
	
	
	private String variance;

	public String getNiveau() {
		return niveau;
	}

	public String getVariance() {
		return variance;
	}
	
	
}
