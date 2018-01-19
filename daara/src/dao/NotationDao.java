package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.Notation;

import dao.interfaces.NotationDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class NotationDao implements NotationDaoInterface < Notation , Long> {
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  NotationDao() {

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

 

    public void persist(Notation entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Notation entity) {

        getCurrentSession().update(entity);

    }

 

    public Notation findById(Long id) {

    	Notation notation = (Notation) getCurrentSession().get(Notation.class, id);

        return notation;

    }

 

    public void delete(Notation entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Notation> findAll() {

        List<Notation> notations = (List<Notation>) getCurrentSession().createQuery("from Notation").list();

        return notations;

    }

 

    public void deleteAll() {

        List<Notation> entityList = findAll();

        for (Notation entity : entityList) {

            delete(entity);

        }

    }



}
