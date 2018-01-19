package service;

import java.util.List;
import org.ninthQuantum.data.Principal;
import dao.PrincipalDao;
import dao.interfaces.PrincipalDaoInterface;

public class PrincipalService {
	
private static PrincipalDao principalDao;
	
	 
	
    public PrincipalService() {

    	principalDao = new PrincipalDao();

    }

 

    public void persist(Principal entity)  {

    	principalDao.openCurrentSessionwithTransaction();

    	principalDao.persist(entity);

    	principalDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Principal entity) {

    	principalDao.openCurrentSessionwithTransaction();

    	principalDao.update(entity);

    	principalDao.closeCurrentSessionwithTransaction();

    }

 

    public Principal findById(Long Id) {

    		principalDao.openCurrentSession();

        Principal principal = principalDao.findById(Id);

        principalDao.closeCurrentSession();

        return principal;

    }

 

    public void delete(Long Id) {

        principalDao.openCurrentSessionwithTransaction();

        Principal principal = principalDao.findById(Id);

        principalDao.delete(principal);

        principalDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Principal > findAll() {

    		principalDao.openCurrentSession();

        List<Principal> principals = principalDao.findAll();

        principalDao.closeCurrentSession();

        return principals;

    }

 

    public void deleteAll()  {

    	principalDao.openCurrentSessionwithTransaction();

    	principalDao.deleteAll();

    	principalDao.closeCurrentSessionwithTransaction();

    }

 

    public PrincipalDaoInterface<Principal, Long> principalDaoInterface() {

        return (PrincipalDaoInterface<Principal, Long>) principalDao;

    }

}
