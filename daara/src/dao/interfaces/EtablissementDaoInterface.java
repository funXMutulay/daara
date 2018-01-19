package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface EtablissementDaoInterface <Etablissement , EtablissementId extends Serializable >{
	
	public void save(Etablissement etablissement);
	
	public void update(Etablissement etablissement);
	
	public Etablissement findById(EtablissementId etablissementId);
	
	public void delete(Etablissement etablissement);
	
	public List<Etablissement> findAll();
	
	public void deleteAll();
	
}
