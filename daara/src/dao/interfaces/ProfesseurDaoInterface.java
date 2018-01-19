package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface ProfesseurDaoInterface <Professeur,Id extends Serializable >{
	
	public void persist(Professeur entity);
	
	public void update(Professeur entity);
	
	public Professeur findById(Long id);
	
	public void delete(Professeur entity);
	
	public List<Professeur> findAll();
	
	public void deleteAll();

}
