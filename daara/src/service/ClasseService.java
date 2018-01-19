package service;

import java.util.List;
import org.ninthQuantum.data.Classe;
import dao.ClasseDao;
import dao.interfaces.ClasseDaoInterface;
import entitiesId.ClasseId;

public class ClasseService {
	
	private static ClasseDao classeDao;
	
	 
	
    public ClasseService() {

    	classeDao = new ClasseDao();

    }

 

    public void persist(Classe entity) {

    	classeDao.openCurrentSessionwithTransaction();

    	classeDao.persist(entity);

    	classeDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Classe entity) {

    	classeDao.openCurrentSessionwithTransaction();

    	classeDao.update(entity);

    	classeDao.closeCurrentSessionwithTransaction();

    }

 

    public Classe findById(ClasseId classeId) {

classeDao.openCurrentSession();

        Classe classe = classeDao.findById(classeId);

        classeDao.closeCurrentSession();

        return classe;

    }

 

    public void delete(ClasseId classeId) {

        classeDao.openCurrentSessionwithTransaction();

        Classe classe = classeDao.findById(classeId);

        classeDao.delete(classe);

        classeDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Classe > findAll() {

    	classeDao.openCurrentSession();

        List<Classe> classes = classeDao.findAll();

        classeDao.closeCurrentSession();

        return classes;

    }

 

    public void deleteAll()  {

    	classeDao.openCurrentSessionwithTransaction();

    	classeDao.deleteAll();

    	classeDao.closeCurrentSessionwithTransaction();

    }

 

    public ClasseDaoInterface<Classe,ClasseId> classeDaoInterface() {

        return (ClasseDaoInterface<Classe,ClasseId>) classeDao;

    }

}
