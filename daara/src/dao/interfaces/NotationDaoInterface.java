package dao.interfaces;

import java.io.Serializable;
import java.util.List;


public interface NotationDaoInterface <Notation,Id extends Serializable>{
	
public void persist(Notation entity);
	
	public void update(Notation entity);
	
	public Notation findById(Long id);
	
	public void delete(Notation entity);
	
	public List<Notation> findAll();
	
	public void deleteAll();


}
