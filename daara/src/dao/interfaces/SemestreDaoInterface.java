package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface SemestreDaoInterface <Semestre,Id extends Serializable > {
	
public void persist(Semestre entity);
	
	public void update(Semestre entity);
	
	public Semestre findById(Long id);
	
	public void delete(Semestre entity);
	
	public List<Semestre> findAll();
	
	public void deleteAll();

}
