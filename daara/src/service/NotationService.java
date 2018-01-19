package service;

import java.util.List;
import org.ninthQuantum.daara.generator.Notation;
import dao.NotationDao;
import dao.interfaces.NotationDaoInterface;


public class NotationService {
	
private static NotationDao notationDao;
	
	 
	
    public NotationService() {

    	notationDao = new NotationDao();

    }

 

    public void persist(Notation entity)  {

    	notationDao.openCurrentSessionwithTransaction();

    	notationDao.persist(entity);

    	notationDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Notation entity)  {

    	notationDao.openCurrentSessionwithTransaction();

    	notationDao.update(entity);

    	notationDao.closeCurrentSessionwithTransaction();

    }

 

    public Notation findById(Long Id) {

    		notationDao.openCurrentSession();

        Notation notation = notationDao.findById (Id );

        notationDao.closeCurrentSession();

        return notation;

    }

 

    public void delete(Long Id) {

        notationDao.openCurrentSessionwithTransaction();

        Notation notation = notationDao.findById(Id);

        notationDao.delete(notation);

        notationDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Notation > findAll() {

    		notationDao.openCurrentSession();

        List<Notation> notations = notationDao.findAll();

        notationDao.closeCurrentSession();

        return notations;

    }

 

    public void deleteAll()  {

    	notationDao.openCurrentSessionwithTransaction();

    	notationDao.deleteAll();

    	notationDao.closeCurrentSessionwithTransaction();

    }

 

    public NotationDaoInterface<Notation,Long> notationDaoInterface() {

        return (NotationDaoInterface<Notation,Long>) notationDao;

    }

}
