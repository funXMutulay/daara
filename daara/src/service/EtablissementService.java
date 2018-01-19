package service;

import dao.EtablissementDao;
import dao.interfaces.EtablissementDaoInterface;
import entitiesId.EtablissementId;
import java.util.List;
import org.ninthQuantum.data.*;

public class EtablissementService {

	private static EtablissementDao etablissementDao;
	
		 
	
		    public EtablissementService() {
	
		    	etablissementDao = new EtablissementDao();
	
		    }
	
		 
	
		    public  void save(Etablissement etablissement) {
	
		    	etablissementDao.openCurrentSessionwithTransaction();
	
		    	etablissementDao.save(etablissement);
	
		    	etablissementDao.closeCurrentSessionwithTransaction();
	
		    }
	
		 
	
		    public void update(Etablissement etablissement) {
	
		    	etablissementDao.openCurrentSessionwithTransaction();
	
		    	etablissementDao.update(etablissement);
	
		    	etablissementDao.closeCurrentSessionwithTransaction();
	
		    }
	
		 
	
		    public Etablissement findById(EtablissementId etablissementId) {
	
	etablissementDao.openCurrentSession();
	
		        Etablissement etablissement = etablissementDao.findById(etablissementId);
	
	etablissementDao.closeCurrentSession();
	
		        return etablissement;
	
		    }
	
		 
	
		    public void delete(EtablissementId etablissementId)  {
	
		        etablissementDao.openCurrentSessionwithTransaction();
	
		        Etablissement etablissement = etablissementDao.findById(etablissementId);
	
		        etablissementDao.delete(etablissement);
	
		        etablissementDao.closeCurrentSessionwithTransaction();
	
		    }
	
		 
	
		    public List<Etablissement > findAll() {
	
		    	etablissementDao.openCurrentSession();
	
		        List<Etablissement> etablissements = etablissementDao.findAll();
	
		        etablissementDao.closeCurrentSession();
	
		        return etablissements;
	
		    }
	
		 
	
		    public void deleteAll(){
	
		    	etablissementDao.openCurrentSessionwithTransaction();
	
		    	etablissementDao.deleteAll();
	
		    	etablissementDao.closeCurrentSessionwithTransaction();
	
		    }
	
		 
	
		    public EtablissementDaoInterface<Etablissement,EtablissementId> etablissementDao() {
	
		        return (EtablissementDaoInterface<Etablissement,EtablissementId>) etablissementDao;
	
		    }
}
