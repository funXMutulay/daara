package service;

import java.util.List;
import org.ninthQuantum.daara.generator.Presence;
import dao.PresenceDao;
import dao.interfaces.PresenceDaoInterface;

public class PresenceService {
	
	private static PresenceDao presenceDao ;
	
	
	 
	
    public PresenceService() {

    	presenceDao = new PresenceDao();

    }

 

    public void persist(Presence entity) {

    	presenceDao.openCurrentSessionwithTransaction();

    	presenceDao.persist(entity);

    	presenceDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Presence entity)  {

    	presenceDao.openCurrentSessionwithTransaction();

    	presenceDao.update(entity);

    	presenceDao.closeCurrentSessionwithTransaction();

    }

 

    public Presence findById(Long Id) {

presenceDao.openCurrentSession();

        Presence Presence = presenceDao.findById( Id );

presenceDao.closeCurrentSession();

        return Presence;

    }

 

    public void delete(Long Id)  {

        presenceDao.openCurrentSessionwithTransaction();

        Presence presence = presenceDao.findById( Id);

        presenceDao.delete(presence);

        presenceDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Presence > findAll() {

    	presenceDao.openCurrentSession();

        List<Presence> Presences = presenceDao.findAll();

        presenceDao.closeCurrentSession();

        return Presences;

    }

 

    public void deleteAll() {

    	presenceDao.openCurrentSessionwithTransaction();

    	presenceDao.deleteAll();

    	presenceDao.closeCurrentSessionwithTransaction();

    }

 

    public PresenceDaoInterface<Presence,Long> presenceDaoInterface() {

        return (PresenceDaoInterface<Presence,Long>) presenceDao;

    }
}
