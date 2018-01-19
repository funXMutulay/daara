package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface AnneeScolaireDaoInterface <AnneeScolaire,Id extends Serializable>{
	
	public void persist(AnneeScolaire entity);
	
	public void update(AnneeScolaire entity);
	
	public AnneeScolaire findById(Long id);
	
	public void delete(AnneeScolaire entity);
	
	public List<AnneeScolaire> findAll();
	
	public void deleteAll();

}
