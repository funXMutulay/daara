package service;

import java.util.List;
import org.ninthQuantum.daara.generator.AffectationSurveillant;
import dao.AffectationSurveillantDao;
import dao.interfaces.AffectationSurveillantDaoInterface;

public class AffectationSurveillantService {
	
private static AffectationSurveillantDao affectationSurveillantDao;
	
	 
	
    public AffectationSurveillantService() {

    	affectationSurveillantDao = new AffectationSurveillantDao();

    }

 

    public void persist(AffectationSurveillant entity) {

    	affectationSurveillantDao.openCurrentSessionwithTransaction();

    	affectationSurveillantDao.persist(entity);

    	affectationSurveillantDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(AffectationSurveillant entity) {

    	affectationSurveillantDao.openCurrentSessionwithTransaction();

    	affectationSurveillantDao.update(entity);

    	affectationSurveillantDao.closeCurrentSessionwithTransaction();

    }

 

    public AffectationSurveillant findById(Long Id) {

    		affectationSurveillantDao.openCurrentSession();

        AffectationSurveillant affectationSurveillant = affectationSurveillantDao.findById(Id);

        affectationSurveillantDao.closeCurrentSession();

        return affectationSurveillant;

    }

 

    public void delete(Long Id)  {

        affectationSurveillantDao.openCurrentSessionwithTransaction();

        AffectationSurveillant affectationSurveillant = affectationSurveillantDao.findById(Id);

        affectationSurveillantDao.delete(affectationSurveillant);

        affectationSurveillantDao.closeCurrentSessionwithTransaction();

    }

 

    public List<AffectationSurveillant > findAll() {

    	affectationSurveillantDao.openCurrentSession();

        List<AffectationSurveillant> affectationSurveillants = affectationSurveillantDao.findAll();

        affectationSurveillantDao.closeCurrentSession();

        return affectationSurveillants;

    }

 

    public void deleteAll()  {

    	affectationSurveillantDao.openCurrentSessionwithTransaction();

    	affectationSurveillantDao.deleteAll();

    	affectationSurveillantDao.closeCurrentSessionwithTransaction();

    }

 

    public AffectationSurveillantDaoInterface<AffectationSurveillant, Long> affectationSurveillantDaoInterface() {

        return (AffectationSurveillantDaoInterface<AffectationSurveillant,Long>) affectationSurveillantDao;

    }

}
