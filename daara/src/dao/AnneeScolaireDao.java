package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.AnneeScolaire;

import dao.interfaces.AnneeScolaireDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class AnneeScolaireDao implements AnneeScolaireDaoInterface<AnneeScolaire,Long> {
	
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  AnneeScolaireDao() {

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

 

    public void persist(AnneeScolaire entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(AnneeScolaire entity) {

        getCurrentSession().update(entity);

    }

 

    public AnneeScolaire findById(Long id) {

    	AnneeScolaire anneeScolaire = (AnneeScolaire) getCurrentSession().get(AnneeScolaire.class, id);

        return anneeScolaire;

    }

 

    public void delete(AnneeScolaire entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<AnneeScolaire> findAll() {

        List<AnneeScolaire> anneeScolaires = (List<AnneeScolaire>) getCurrentSession().createQuery("from AnneeScolaire").list();

        return anneeScolaires;

    }

 

    public void deleteAll() {

        List<AnneeScolaire> entityList = findAll();

        for (AnneeScolaire entity : entityList) {

            delete(entity);

        }

    }

}
