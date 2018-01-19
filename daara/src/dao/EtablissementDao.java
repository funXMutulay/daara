package dao;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.data.Etablissement;
import dao.interfaces.EtablissementDaoInterface;
import entitiesId.EtablissementId;

/*
 * Created By Mamadou Kébé
 */


public  class  EtablissementDao implements  EtablissementDaoInterface < Etablissement , EtablissementId >{
	
	
		private Session currentSession;

	    private Transaction currentTransaction;

	 

	    public EtablissementDao() {

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

	 

	    public void save(Etablissement entity) {

	       getCurrentSession().saveOrUpdate(entity);

	    }

	 

	    public void update(Etablissement entity) {

	        getCurrentSession().update(entity);

	    }

	 

	    public Etablissement findById (EtablissementId etablissementId) {

	    	Etablissement etablissement = (Etablissement) getCurrentSession().get(Etablissement.class, etablissementId);

	        return etablissement;

	    }

	 

	    public void delete(Etablissement entity) {

	        getCurrentSession().delete(entity);

	    }

	 

	    @SuppressWarnings("unchecked")

	    public List<Etablissement> findAll() {

	        List<Etablissement> etablissements = (List<Etablissement>) getCurrentSession().createQuery("from Etablissement").list();

	        return etablissements;

	    }

	 

	    public void deleteAll() {

	        List<Etablissement> entityList = findAll();

	        for (Etablissement entity: entityList) {

	            delete(entity);

	        }

	    }


		
	
		}


