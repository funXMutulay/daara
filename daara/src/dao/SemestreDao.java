package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.generator.Semestre;

import dao.interfaces.SemestreDaoInterface;

/*
 * Created By Mamadou Kébé
 */

public class SemestreDao implements SemestreDaoInterface<Semestre,Long>{
	
	private Session currentSession;

    

    private Transaction currentTransaction;

 

    public  SemestreDao() {

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

 

    public void persist(Semestre entity) {

        getCurrentSession().save(entity);

    }

 

    public void update(Semestre entity) {

        getCurrentSession().update(entity);

    }

 

    public Semestre findById(Long id) {

    	Semestre semestre = (Semestre) getCurrentSession().get(Semestre.class, id);

        return semestre;

    }

 

    public void delete(Semestre entity) {

        getCurrentSession().delete(entity);

    }

 

    @SuppressWarnings("unchecked")

    public List<Semestre> findAll() {

        List<Semestre> semestres = (List<Semestre>) getCurrentSession().createQuery("from Semestre").list();

        return semestres;

    }

 

    public void deleteAll() {

        List<Semestre> entityList = findAll();

        for (Semestre entity : entityList) {

            delete(entity);

        }

    }

}
