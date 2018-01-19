package dao.interfaces;

import java.io.Serializable;
import java.util.List;

/*
 * Created By Mamadou Kébé
 */


public interface AffectationSurveillantDaoInterface <AffectationSurveillant , Id extends Serializable >{
	
	
	public void persist(AffectationSurveillant entity);
	
	public void update(AffectationSurveillant entity);
	
	public AffectationSurveillant findById(Long id);
	
	public void delete(AffectationSurveillant entity);
	
	public List<AffectationSurveillant> findAll();
	
	public void deleteAll();

}
