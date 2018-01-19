package service;

import java.util.List;
import org.ninthQuantum.daara.generator.AffectationProfesseur;
import dao.AffectationProfesseurDao;
import dao.interfaces.AffectationProfesseurDaoInterface;

/*
 * Created By Mamadou Kébé
 */
public class AffectationProfesseurService {
	
	private static AffectationProfesseurDao affectationProfesseurDao;
	
	 
	
    public AffectationProfesseurService() {

    	affectationProfesseurDao = new AffectationProfesseurDao();

    }

 

    public void persist(AffectationProfesseur entity) {

    	affectationProfesseurDao.openCurrentSessionwithTransaction();

    	affectationProfesseurDao.persist(entity);

    	affectationProfesseurDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(AffectationProfesseur entity)  {

    	affectationProfesseurDao.openCurrentSessionwithTransaction();

    	affectationProfesseurDao.update(entity);

    	affectationProfesseurDao.closeCurrentSessionwithTransaction();

    }

 

    public AffectationProfesseur findById(Long Id) {

affectationProfesseurDao.openCurrentSession();

        AffectationProfesseur affectationProfesseur = affectationProfesseurDao.findById(Id);

affectationProfesseurDao.closeCurrentSession();

        return affectationProfesseur;

    }

 

    public void delete(Long Id)  {

        affectationProfesseurDao.openCurrentSessionwithTransaction();

        AffectationProfesseur affectationProfesseur = affectationProfesseurDao.findById(Id);

        affectationProfesseurDao.delete(affectationProfesseur);

        affectationProfesseurDao.closeCurrentSessionwithTransaction();

    }

 

    public List<AffectationProfesseur > findAll() {

    	affectationProfesseurDao.openCurrentSession();

        List<AffectationProfesseur> affectationProfesseurs = affectationProfesseurDao.findAll();

        affectationProfesseurDao.closeCurrentSession();

        return affectationProfesseurs;

    }

 

    public void deleteAll() {

    	affectationProfesseurDao.openCurrentSessionwithTransaction();

    	affectationProfesseurDao.deleteAll();

    	affectationProfesseurDao.closeCurrentSessionwithTransaction();

    }

 

    public AffectationProfesseurDaoInterface<AffectationProfesseur, Long> affectationProfesseurDaoInterface() {

        return (AffectationProfesseurDaoInterface<AffectationProfesseur, Long>) affectationProfesseurDao;

    }

}
