package service;

import java.util.List;
import org.ninthQuantum.daara.entities.Etudiant;
import dao.EtudiantDao;
import dao.interfaces.EtudiantDaoInterface;
import entitiesId.EtudiantId;

public class EtudiantService {

	private static EtudiantDao etudiantDao;
	
	 
	
    public EtudiantService() {

    	etudiantDao = new EtudiantDao();

    }

 

    public  void persist(Etudiant entity)  {

    	etudiantDao.openCurrentSessionwithTransaction();

    	etudiantDao.persist(entity);

    	etudiantDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Etudiant entity) {

    	etudiantDao.openCurrentSessionwithTransaction();

    	etudiantDao.update(entity);

    	etudiantDao.closeCurrentSessionwithTransaction();

    }

 

    public Etudiant findById(EtudiantId etudiantId) {

    		etudiantDao.openCurrentSession();

        Etudiant etudiant = etudiantDao.findById(etudiantId);

        etudiantDao.closeCurrentSession();

        return etudiant;

    }

 

    public void delete(EtudiantId etudiantId)  {

        etudiantDao.openCurrentSessionwithTransaction();

        Etudiant etudiant = etudiantDao.findById(etudiantId);

        etudiantDao.delete(etudiant);

        etudiantDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Etudiant > findAll() {

    		etudiantDao.openCurrentSession();

        List<Etudiant> etudiants = etudiantDao.findAll();

        etudiantDao.closeCurrentSession();

        return etudiants;

    }

 

    public void deleteAll()  {

    	etudiantDao.openCurrentSessionwithTransaction();

    	etudiantDao.deleteAll();

    	etudiantDao.closeCurrentSessionwithTransaction();

    }

 

    public EtudiantDaoInterface<Etudiant,EtudiantId> etudiantDaoInterface() {

        return (EtudiantDaoInterface<Etudiant,EtudiantId>) etudiantDao;

    }
}
