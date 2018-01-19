package dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface PresenceDaoInterface <Presence,Id  extends Serializable>{
	
public void persist(Presence entity);
	
	public void update(Presence entity);
	
	public Presence findById(Long id);
	
	public void delete(Presence entity);
	
	public List<Presence> findAll();
	
	public void deleteAll();
	
}
