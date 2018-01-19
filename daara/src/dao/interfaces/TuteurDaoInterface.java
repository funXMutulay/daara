package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */


public interface TuteurDaoInterface <Tuteur,Id extends Serializable>

{
	
	
	public void persist(Tuteur entity);
	
	public void update(Tuteur entity);
	
	public Tuteur findById(Long id);
	
	public void delete(Tuteur entity);
	
	public List<Tuteur> findAll();
	
	public void deleteAll();

}
