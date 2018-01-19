package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.entities.Tuteur;

import dao.interfaces.TuteurDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class TuteurDao implements TuteurDaoInterface<Tuteur,Long>{
	
private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  TuteurDao() {

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

 

    public void persist(Tuteur entity) {

        getCurrentSession().save(entity);

    }

 

    public void update(Tuteur entity) {

        getCurrentSession().update(entity);

    }

 

    public Tuteur findById(Long id) {

    	Tuteur tuteur = (Tuteur) getCurrentSession().get(Tuteur.class, id);

        return tuteur;

    }

 

    public void delete(Tuteur entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Tuteur> findAll() {

        List<Tuteur> tuteurs = (List<Tuteur>) getCurrentSession().createQuery("from Tuteur").list();

        return tuteurs;

    }

 

    public void deleteAll() {

        List<Tuteur> entityList = findAll();

        for (Tuteur entity : entityList) {

            delete(entity);

        }

    }


}
