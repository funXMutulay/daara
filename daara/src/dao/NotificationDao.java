package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.Notification;

import dao.interfaces.NotificationDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class NotificationDao implements NotificationDaoInterface <Notification,Long> {
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  NotificationDao() {

    }

    private static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration().configure();

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;

    }


    public Session openCurrentSession() {

        currentSession = getSessionFactory().openSession();

        return currentSession;

    }

public Session openCurrentSessionwithTransaction() {

    currentSession = getSessionFactory().openSession();

        currentTransaction = (Transaction) currentSession.beginTransaction();

        return currentSession;

    }

     

    public void closeCurrentSession() {

        currentSession.close();

    }

     

    public void closeCurrentSessionwithTransaction() {

        currentTransaction.commit();

        currentSession.close();

    }

     

  
 

    public Session getCurrentSession() {

        return currentSession;

    }

 

    public void setCurrentSession(Session currentSession) {

        this.currentSession = currentSession;

    }

 

    public Transaction getCurrentTransaction() {

        return currentTransaction;

    }

 

    public void setCurrentTransaction(Transaction currentTransaction) {

        this.currentTransaction = currentTransaction;

    }

 

    public void persist(Notification entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Notification entity) {

        getCurrentSession().update(entity);

    }

 

    public Notification findById(Long id) {

    	Notification notification = (Notification) getCurrentSession().get(Notification.class, id);

        return notification;

    }

 

    public void delete(Notification entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Notification> findAll() {

        List<Notification> notifications = (List<Notification>) getCurrentSession().createQuery("from Notification").list();

        return notifications;

    }

 

    public void deleteAll() {

        List<Notification> entityList = findAll();

        for (Notification entity : entityList) {

            delete(entity);

        }

    }

}
