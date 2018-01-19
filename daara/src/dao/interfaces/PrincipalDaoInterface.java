package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */
public interface PrincipalDaoInterface <Principal,Id extends Serializable > {
	
public void persist(Principal entity);
	
	public void update(Principal entity);
	
	public Principal findById(Long id);
	
	public void delete(Principal entity);
	
	public List<Principal> findAll();
	
	public void deleteAll();

}
