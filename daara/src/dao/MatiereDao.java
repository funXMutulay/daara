package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.entities.Matiere;

import dao.interfaces.MatiereDaoInterface;
import entitiesId.MatiereId;

/*
 * Created By Mamadou Kébé
 */

public class MatiereDao implements MatiereDaoInterface<Matiere,MatiereId> {
	
private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  MatiereDao() {

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

     

    public void closeCurrentSessionwithTransaction() 
    {

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

 

    public void persist(Matiere entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Matiere entity) {

        getCurrentSession().update(entity);

    }

 

    public Matiere findById(MatiereId matiereId) {

    	Matiere matiere = (Matiere) getCurrentSession().get(Matiere.class, matiereId);

        return matiere;

    }

 

    public void delete(Matiere entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Matiere> findAll() {

        List<Matiere> matieres = (List<Matiere>) getCurrentSession().createQuery("from Matiere").list();

        return matieres;

    }

 

    public void deleteAll() {

        List<Matiere> entityList = findAll();

        for (Matiere entity : entityList) {

            delete(entity);

        }

    }


}
