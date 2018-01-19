package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.data.Classe;

import dao.interfaces.ClasseDaoInterface;
import entitiesId.ClasseId;

/*
 * Created By Mamadou Kébé
 */

public class ClasseDao implements ClasseDaoInterface<Classe ,ClasseId>{
	
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  ClasseDao() {

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

 

    public void persist(Classe entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Classe entity) {

        getCurrentSession().update(entity);

    }

 

    public Classe findById(ClasseId classeId) {

    	Classe classe = (Classe) getCurrentSession().get(Classe.class, classeId);

        return classe;

    }

 

    public void delete(Classe entity) {

        getCurrentSession().delete(entity);

    }

 

   
    @SuppressWarnings("unchecked")
    public List<Classe> findAll() {

        List<Classe> classes = (List<Classe>) getCurrentSession().createQuery("from Classe").list();

        return classes;

    }

 

    public void deleteAll() {

        List<Classe> entityList = findAll();

        for (Classe entity : entityList) {

            delete(entity);

        }

    }

}
