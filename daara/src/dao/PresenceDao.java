package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.Presence;

import dao.interfaces.PresenceDaoInterface;
/*
 * Created By Mamadou Kébé
 */

public class PresenceDao implements PresenceDaoInterface <Presence,Long> {
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  PresenceDao() {

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

     

    public void closeCurrentSessionwithTransaction()  {

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

 

    public void persist(Presence entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Presence entity) {

        getCurrentSession().update(entity);

    }

 

    public Presence findById(Long id) {

    	Presence presence = (Presence) getCurrentSession().get(Presence.class, id);

        return presence;

    }

 

    public void delete(Presence entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Presence> findAll() {

        List<Presence> presences = (List<Presence>) getCurrentSession().createQuery("from Presence").list();

        return presences;

    }

 

    public void deleteAll() {

        List<Presence> entityList = findAll();

        for (Presence entity : entityList) {

            delete(entity);

        }

    }

}
