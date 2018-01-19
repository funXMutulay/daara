package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.data.Surveillant;

import dao.interfaces.SurveillantDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class SurveillantDao implements SurveillantDaoInterface < Surveillant , Long > {
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  SurveillantDao() {

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

 

    public void persist(Surveillant entity) {

        getCurrentSession().save(entity);

    }

 

    public void update(Surveillant entity) {

        getCurrentSession().update(entity);

    }

 

    public Surveillant findById(Long id) {

    	Surveillant surveillant = (Surveillant) getCurrentSession().get(Surveillant.class, id);

        return surveillant;

    }

 

    public void delete(Surveillant entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Surveillant> findAll() {

        List<Surveillant> surveillants = (List<Surveillant>) getCurrentSession().createQuery("from Surveillant").list();

        return surveillants;

    }

 

    public void deleteAll() {

        List<Surveillant> entityList = findAll();

        for (Surveillant entity : entityList) {

            delete(entity);

        }

    }

}
