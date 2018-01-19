package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.data.Professeur;

/*
 * Created By Mamadou Kébé
 */

public class ProfesseurDao extends AbstractDao<Professeur,Long>{
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  ProfesseurDao() {

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

 

    public void persist(Professeur entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Professeur entity) {

        getCurrentSession().update(entity);

    }

 

    public Professeur findById(Long id) {

    	Professeur professeur = (Professeur) getCurrentSession().get(Professeur.class, id);

        return professeur;

    }

 

    public void delete(Professeur entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Professeur> findAll() {

        List<Professeur> professeurs = (List<Professeur>) getCurrentSession().createQuery("from Professeur").list();

        return professeurs;

    }

 

    public void deleteAll() {

        List<Professeur> entityList = findAll();

        for (Professeur entity : entityList) {

            delete(entity);

        }

    }
}
