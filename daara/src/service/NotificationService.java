package service;

import java.util.List;
import org.ninthQuantum.daara.generator.Notification;
import dao.NotificationDao;
import dao.interfaces.NotificationDaoInterface;

public class NotificationService {

	private static NotificationDao notificationDao;
	
	 
	
    public NotificationService() {

    	notificationDao = new NotificationDao();

    }

 

    public void persist(Notification entity) {

    	notificationDao.openCurrentSessionwithTransaction();

    	notificationDao.persist(entity);

    	notificationDao.closeCurrentSessionwithTransaction();

    }

 

    public void update(Notification entity)  {

    	notificationDao.openCurrentSessionwithTransaction();

    	notificationDao.update(entity);

    	notificationDao.closeCurrentSessionwithTransaction();

    }

 

    public Notification findById(Long Id) {

    		notificationDao.openCurrentSession();

        Notification notification = notificationDao.findById(Id);

        notificationDao.closeCurrentSession();

        return notification;

    }

 

    public void delete(Long Id)  {

        notificationDao.openCurrentSessionwithTransaction();

        Notification notification = notificationDao.findById(Id);

        notificationDao.delete(notification);

        notificationDao.closeCurrentSessionwithTransaction();

    }

 

    public List<Notification > findAll() {

    		notificationDao.openCurrentSession();

        List<Notification> notifications = notificationDao.findAll();

        notificationDao.closeCurrentSession();

        return notifications;

    }

 

    public void deleteAll() {

    	notificationDao.openCurrentSessionwithTransaction();

    	notificationDao.deleteAll();

    	notificationDao.closeCurrentSessionwithTransaction();

    }

 

    public NotificationDaoInterface<Notification,Long> notificationDaoInterface() {

        return (NotificationDaoInterface<Notification,Long>) notificationDao;

    }

}
