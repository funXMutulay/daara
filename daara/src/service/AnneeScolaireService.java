package service;

import java.util.List;
import org.ninthQuantum.daara.generator.AnneeScolaire;
import dao.AnneeScolaireDao;
import dao.interfaces.AnneeScolaireDaoInterface;

public class AnneeScolaireService {
	
private static AnneeScolaireDao anneeScolaireDao;
	
	 
	
    public AnneeScolaireService() {

    	anneeScolaireDao = new AnneeScolaireDao();

    }

 

    public void persist(AnneeScolaire entity) {

    	anneeScolaireDao.openCurrentSessionwithTransaction();

    	anneeScolaireDao.persist(entity);

    	anneeScolaireDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(AnneeScolaire entity) {

    	anneeScolaireDao.openCurrentSessionwithTransaction();

    	anneeScolaireDao.update(entity);

    	anneeScolaireDao.closeCurrentSessionwithTransaction();

    }

 

    public AnneeScolaire findById(Long Id) {

    		anneeScolaireDao.openCurrentSession();

        AnneeScolaire anneeScolaire = anneeScolaireDao.findById(Id);

        anneeScolaireDao.closeCurrentSession();

        return anneeScolaire;

    }

 

    public void delete(Long Id)  {

        anneeScolaireDao.openCurrentSessionwithTransaction();

        AnneeScolaire anneeScolaire = anneeScolaireDao.findById(Id);

        anneeScolaireDao.delete(anneeScolaire);

        anneeScolaireDao.closeCurrentSessionwithTransaction();

    }

 

    public List<AnneeScolaire > findAll() {

    	   anneeScolaireDao.openCurrentSession();

        List<AnneeScolaire> anneeScolaires = anneeScolaireDao.findAll();

        anneeScolaireDao.closeCurrentSession();

        return anneeScolaires;

    }

 

    public void deleteAll() {

    	anneeScolaireDao.openCurrentSessionwithTransaction();

    	anneeScolaireDao.deleteAll();

    	anneeScolaireDao.closeCurrentSessionwithTransaction();

    }

 

    public AnneeScolaireDaoInterface<AnneeScolaire,Long>  anneeScolaireDaoInterface() {

        return (AnneeScolaireDaoInterface<AnneeScolaire,Long>) anneeScolaireDao;

    }

}
