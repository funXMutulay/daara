package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.AffectationSurveillant;

import dao.interfaces.AffectationSurveillantDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class AffectationSurveillantDao implements AffectationSurveillantDaoInterface<AffectationSurveillant,Long>{
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public AffectationSurveillantDao() {

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

 

    public  void persist ( AffectationSurveillant entity) {

        getCurrentSession().persist(entity);

    }

 

    public void update(AffectationSurveillant entity) {

        getCurrentSession().update(entity);

    }

 

    public AffectationSurveillant findById(Long id) {

    	AffectationSurveillant affectationSurveillant = (AffectationSurveillant) getCurrentSession().get(AffectationSurveillant.class, id);

        return affectationSurveillant;

    }

 

    public void delete(AffectationSurveillant entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<AffectationSurveillant> findAll() {

        List<AffectationSurveillant> affectationSurveillants = (List<AffectationSurveillant>) getCurrentSession().createQuery("from AffectationSurveillant").list();

        return affectationSurveillants;

    }

 

    public void deleteAll() {

        List<AffectationSurveillant> entityList = findAll();

        for (AffectationSurveillant entity : entityList) {

            delete(entity);

        }

    }

}
