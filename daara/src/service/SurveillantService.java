package service;

import java.util.List;

import org.ninthQuantum.data.Surveillant;


import dao.SurveillantDao;
import dao.interfaces.SurveillantDaoInterface;

public class SurveillantService {
	
	private static SurveillantDao surveillantDao;



public SurveillantService() {

	surveillantDao = new SurveillantDao();

}



public void persist(Surveillant entity)  {

	surveillantDao.openCurrentSessionwithTransaction();

	surveillantDao.persist(entity);

	surveillantDao.closeCurrentSessionwithTransaction();

}



public void update(Surveillant entity)  {

	surveillantDao.openCurrentSessionwithTransaction();

	surveillantDao.update(entity);

	surveillantDao.closeCurrentSessionwithTransaction();

}



public Surveillant findById(Long Id) {

		surveillantDao.openCurrentSession();

    Surveillant surveillant = surveillantDao.findById(Id);

    surveillantDao.closeCurrentSession();

    return surveillant;

}



public void delete(Long Id) {

    surveillantDao.openCurrentSessionwithTransaction();

    Surveillant surveillant = surveillantDao.findById(Id);

    surveillantDao.delete(surveillant);

    surveillantDao.closeCurrentSessionwithTransaction();

}



public List<Surveillant > findAll() {

	surveillantDao.openCurrentSession();

    List<Surveillant> surveillants = surveillantDao.findAll();

    surveillantDao.closeCurrentSession();

    return surveillants;

}



public void deleteAll() {

	surveillantDao.openCurrentSessionwithTransaction();

	surveillantDao.deleteAll();

	surveillantDao.closeCurrentSessionwithTransaction();

}



public SurveillantDaoInterface<Surveillant,Long> surveillantDaoInterface() {

    return (SurveillantDaoInterface<Surveillant,Long>) surveillantDao;

}

}
