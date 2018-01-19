package service;

import java.util.List;
import org.ninthQuantum.data.Professeur;

import dao.ProfesseurDao;
import dao.interfaces.ProfesseurDaoInterface;

public class ProfesseurService {
	private static ProfesseurDao professeurDao;
	
	 
	
    public ProfesseurService() {

    	professeurDao = new ProfesseurDao();

    }

 

    public  void persist(Professeur entity)  {

    	professeurDao.openCurrentSessionwithTransaction();

    	professeurDao.persist(entity);

    	professeurDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Professeur entity) {

    	professeurDao.openCurrentSessionwithTransaction();

    	professeurDao.update(entity);

    	professeurDao.closeCurrentSessionwithTransaction();

    }

 

    public Professeur findById(Long Id) {

    		professeurDao.openCurrentSession();

        Professeur professeur = professeurDao.findById(Id);

        professeurDao.closeCurrentSession();

        return professeur;

    }

 

    public void delete(Long Id) {

        professeurDao.openCurrentSessionwithTransaction();

        Professeur professeur = professeurDao.findById(Id);

        professeurDao.delete(professeur);

        professeurDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Professeur > findAll() {

    	professeurDao.openCurrentSession();

        List<Professeur> professeurs = professeurDao.findAll();

        professeurDao.closeCurrentSession();

        return professeurs;

    }

 

    public void deleteAll()  {

    	professeurDao.openCurrentSessionwithTransaction();

    	professeurDao.deleteAll();

    	professeurDao.closeCurrentSessionwithTransaction();

    }

 

    @SuppressWarnings("unchecked")
	public ProfesseurDaoInterface<Professeur,Long> professeurDaoInterface() {

        return (ProfesseurDaoInterface<Professeur, Long>) professeurDao;

    }
}
