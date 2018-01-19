package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.AffectationProfesseur;

import dao.interfaces.AffectationProfesseurDaoInterface;


/*
 * Created By Mamadu Kébé
 */ 

public class AffectationProfesseurDao implements  AffectationProfesseurDaoInterface <AffectationProfesseur , Long> {
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public AffectationProfesseurDao() {

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

 

    public  void persist(AffectationProfesseur entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(AffectationProfesseur entity) {

        getCurrentSession().update(entity);

    }

 

    public AffectationProfesseur findById (Long id) {

    	AffectationProfesseur affectationProfesseur = (AffectationProfesseur) getCurrentSession().get(AffectationProfesseur.class, id);

        return affectationProfesseur;

    }

 

    public void delete(AffectationProfesseur entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<AffectationProfesseur> findAll() {

        List<AffectationProfesseur> affectationProfesseurs = (List<AffectationProfesseur>) getCurrentSession().createQuery("from AffectationProfesseur").list();

        return affectationProfesseurs;

    }

 

    public void deleteAll() {

        List<AffectationProfesseur> entityList = findAll();

        for (AffectationProfesseur entity : entityList) {

            delete(entity);

        }

    }


	

}
