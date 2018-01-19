package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.entities.Etudiant;

import dao.interfaces.EtudiantDaoInterface;
import entitiesId.EtudiantId;

/*
 * Created By Mamadou Kébé
 */

public class  EtudiantDao implements EtudiantDaoInterface<Etudiant,EtudiantId>{
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public EtudiantDao() {

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

 

    public void persist(Etudiant entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(Etudiant entity) {

        getCurrentSession().update(entity);

    }

 

    public Etudiant findById (EtudiantId etudiantId) {

    	Etudiant etudiant = (Etudiant) getCurrentSession().get(Etudiant.class, etudiantId);

        return etudiant;

    }

 

    public void delete(Etudiant entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Etudiant> findAll() {

        List<Etudiant> etudiants = (List<Etudiant>) getCurrentSession().createQuery("from Etudiant").list();

        return etudiants;

    }

 

    public void deleteAll() {

        List<Etudiant> entityList = findAll();

        for (Etudiant entity : entityList) {

            delete(entity);

        }

    }


	

}
