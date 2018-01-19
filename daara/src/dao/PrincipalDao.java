package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.data.Principal;

import dao.interfaces.PrincipalDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class PrincipalDao implements PrincipalDaoInterface<Principal,Long> {
	
private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  PrincipalDao() {

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

 

    public void persist(Principal entity) {

        openCurrentSession().persist(entity);

    }

 

    public void update(Principal entity) {

        getCurrentSession().update(entity);

    }

 

    public Principal findById(Long id) {

    	Principal principal = (Principal) getCurrentSession().get(Principal.class, id);

        return principal;

    }

 

    public void delete(Principal entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Principal> findAll() {

        List<Principal> principals = (List<Principal>) getCurrentSession().createQuery("from Principal").list();

        return principals;

    }

 

    public void deleteAll() {

        List<Principal> entityList = findAll();

        for (Principal entity : entityList) {

            delete(entity);

        }

    }

}
