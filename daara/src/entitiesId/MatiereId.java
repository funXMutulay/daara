package entitiesId;

import java.io.Serializable;

public class MatiereId implements Serializable{
	
	
	private String nomMat;
	private String codeMat;
	
	public MatiereId(){
		
	}
	public MatiereId(String nomMat, String codeMat) {
		super();
		this.nomMat = nomMat;
		this.codeMat = codeMat;
	}
	public String getNomMat() {
		return nomMat;
	}
	public String getCodeMat() {
		return codeMat;
	}
}
