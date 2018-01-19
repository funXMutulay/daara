package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface SurveillantDaoInterface <Surveillant,Id extends Serializable >{
	
	public void persist(Surveillant entity);
	
	public void update(Surveillant entity);
	
	public Surveillant findById(Long id);
	
	public void delete(Surveillant entity);
	
	public List<Surveillant> findAll();
	
	public void deleteAll();
}
