package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */
public interface ClasseDaoInterface <Classe,ClasseId extends Serializable>{
	
	public void persist(Classe entity);
	
	public void update(Classe entity);
	
	public Classe findById(ClasseId classeId);
	
	public void delete(Classe entity);
	
	public List<Classe> findAll();
	
	public void deleteAll();

}
