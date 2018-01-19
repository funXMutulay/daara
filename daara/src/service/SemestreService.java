package service;

import java.util.List;
import org.ninthQuantum.daara.generator.Semestre;
import dao.SemestreDao;
import dao.interfaces.SemestreDaoInterface;

/*
 * Created By Mamadou Kébé
 */


public class SemestreService {

	
	
	private static SemestreDao semestreDao;
	
	 
	
    public SemestreService() {

    	semestreDao = new SemestreDao();

    }

 

    public void persist(Semestre entity) {

    	semestreDao.openCurrentSessionwithTransaction();

    	semestreDao.persist(entity);

    	semestreDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Semestre entity)  {

    	semestreDao.openCurrentSessionwithTransaction();

    	semestreDao.update(entity);

    	semestreDao.closeCurrentSessionwithTransaction();

    }

 

    public Semestre findById(Long Id) {

    		semestreDao.openCurrentSession();

        Semestre semestre = semestreDao.findById(Id);

        semestreDao.closeCurrentSession();

        return semestre;

    }

 

    public void delete(Long Id)  {

        semestreDao.openCurrentSessionwithTransaction();

        Semestre semestre = semestreDao.findById(Id);

        semestreDao.delete(semestre);

        semestreDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Semestre > findAll() {

    	semestreDao.openCurrentSession();

        List<Semestre> semestres = semestreDao.findAll();

        semestreDao.closeCurrentSession();

        return semestres;

    }

 

    public void deleteAll()  {

    	semestreDao.openCurrentSessionwithTransaction();

    	semestreDao.deleteAll();

    	semestreDao.closeCurrentSessionwithTransaction();

    }

 

    public SemestreDaoInterface<Semestre,Long> semestreDaoInterface() {

        return (SemestreDaoInterface<Semestre,Long>) semestreDao;

    }

}
