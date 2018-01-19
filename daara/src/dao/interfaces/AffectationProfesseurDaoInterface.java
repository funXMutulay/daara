package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */

public interface AffectationProfesseurDaoInterface <AffectationProfesseur,Id extends Serializable > {
	
	public void persist(AffectationProfesseur entity);
	
	public void update(AffectationProfesseur entity);
	
	public AffectationProfesseur findById(Long id);
	
	public void delete(AffectationProfesseur entity);
	
	public List<AffectationProfesseur> findAll();
	
	public void deleteAll();

}
