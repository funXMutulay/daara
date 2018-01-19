package service;

import java.util.List;
import org.ninthQuantum.daara.entities.Matiere;
import dao.MatiereDao;
import dao.interfaces.MatiereDaoInterface;
import entitiesId.MatiereId;

public class MatiereService {
	
	private static MatiereDao matiereDao;
	
	 
	
    public MatiereService() {

    	matiereDao = new MatiereDao();

    }

 

    public void persist(Matiere entity) {

    	matiereDao.openCurrentSessionwithTransaction();

    	matiereDao.persist(entity);

    	matiereDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Matiere entity)  {

    	matiereDao.openCurrentSessionwithTransaction();

    	matiereDao.update(entity);

    	matiereDao.closeCurrentSessionwithTransaction();

    }

 

    public Matiere findById(MatiereId matiereId) {

    	matiereDao.openCurrentSession();

    Matiere matiere = matiereDao.findById(matiereId);

    matiereDao.closeCurrentSession();

    return matiere;

    }

 

    public void delete(MatiereId matiereId) {

        matiereDao.openCurrentSessionwithTransaction();

        Matiere matiere = matiereDao.findById(matiereId);

        matiereDao.delete(matiere);

        matiereDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Matiere > findAll() {

    		matiereDao.openCurrentSession();

        List<Matiere> matieres = matiereDao.findAll();

        matiereDao.closeCurrentSession();

        return matieres;

    }

 

    public void deleteAll() {

    	matiereDao.openCurrentSessionwithTransaction();

    	matiereDao.deleteAll();

    	matiereDao.closeCurrentSessionwithTransaction();

    }

 

    public MatiereDaoInterface<Matiere,MatiereId> matiereDaoInterface() {

        return (MatiereDaoInterface<Matiere,MatiereId>) matiereDao;

    }

}
