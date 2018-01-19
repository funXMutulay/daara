package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface MatiereDaoInterface <Matiere, MatiereId extends Serializable>{
	
 public void persist(Matiere entity);
	
	public void update(Matiere entity);
	
	public Matiere findById(MatiereId matiereId);
	
	public void delete(Matiere entity);
	
	public List<Matiere> findAll();
	
	public void deleteAll();

}
