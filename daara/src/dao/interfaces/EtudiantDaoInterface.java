package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface EtudiantDaoInterface <Etudiant,EtudiantId extends Serializable>{

	public void persist(Etudiant entity);
	
	public void update(Etudiant entity);
	
	public Etudiant findById(EtudiantId etudiantId);
	
	public void delete(Etudiant entity);
	
	public List<Etudiant> findAll();
	
	public void deleteAll();
}
