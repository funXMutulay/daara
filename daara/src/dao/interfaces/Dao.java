package dao.interfaces;

import java.util.List;

import org.hibernate.Session;
/*
 * Created By Mamadou Kébé
 */
public interface Dao<T,ID> {
	

		public T findById(ID id);
		
		public List<T> findAll();
		
		public  void persist(T entity);
		
		public void delete(T entity);
		
		public void flush();
		
		public void clear();

		public void setSession(Session session);
	}

