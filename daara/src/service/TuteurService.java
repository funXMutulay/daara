package service;

import java.util.List;
import org.ninthQuantum.daara.entities.Tuteur;
import dao.TuteurDao;
import dao.interfaces.TuteurDaoInterface;

public class TuteurService {

	private static TuteurDao tuteurDao;
	
	 
	
    public TuteurService() {

    	tuteurDao = new TuteurDao();

    }

 

    public void persist(Tuteur entity)  {

    	tuteurDao.openCurrentSessionwithTransaction();

    	tuteurDao.persist(entity);

    	tuteurDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Tuteur entity) {

    	tuteurDao.openCurrentSessionwithTransaction();

    	tuteurDao.update(entity);

    	tuteurDao.closeCurrentSessionwithTransaction();

    }

 

    public Tuteur findById(Long Id) {

    		tuteurDao.openCurrentSession();

        Tuteur tuteur = tuteurDao.findById(Id);

        tuteurDao.closeCurrentSession();

        return tuteur;

    }

 

    public void delete(Long Id) {

        tuteurDao.openCurrentSessionwithTransaction();

        Tuteur tuteur = tuteurDao.findById(Id);

        tuteurDao.delete(tuteur);

        tuteurDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Tuteur > findAll() {

    	   tuteurDao.openCurrentSession();

        List<Tuteur> tuteurs = tuteurDao.findAll();

        tuteurDao.closeCurrentSession();

        return tuteurs;

    }

 

    public void deleteAll()  {

    	tuteurDao.openCurrentSessionwithTransaction();

    	tuteurDao.deleteAll();

    	tuteurDao.closeCurrentSessionwithTransaction();

    }

 

    public TuteurDaoInterface<Tuteur,Long> tuteurDaoInterface() {

        return (TuteurDaoInterface<Tuteur,Long>) tuteurDao;

    }

}
