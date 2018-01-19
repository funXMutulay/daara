package dao;

/*
 * Created By Mamadu Kébé
 */
	
	import java.io.Serializable;
	import java.lang.reflect.ParameterizedType;
	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.criterion.Criterion;
	

	import dao.interfaces.Dao;

	public class AbstractDao<T,ID extends Serializable> implements Dao<T,ID> {

		private Class<T> persistentClass;
		private Session session;
		
		
		@SuppressWarnings("unchecked")
		public AbstractDao(){
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		
		
		
		public Session getSession() {
			return session;
		}



		public void setSession(Session session) {
			this.session = session;
		}



		public Class<T> getPersistentClass(){
			return persistentClass;
		}
		
		
		public T findById(ID id) {
			return (T) getSession().load(this.getPersistentClass(), id);
		}

		public List<T> findAll() {
			return this.findByCriteria();
		}

		
		@SuppressWarnings({ "deprecation", "unchecked" })
		protected List<T> findByCriteria(Criterion ... criterion){
			Criteria crit = this.getSession().createCriteria(this.getPersistentClass());
			
			for(Criterion c: criterion){
				crit.add(c);
			}
			return (List<T>) crit.list();	
		}
		
		@Override
		public  void  persist(T entity) {
			this.getSession().saveOrUpdate(entity);
			
		}

		@Override
		public void delete(T entity) {
			this.getSession().delete(entity);
		}

		@Override
		public void flush() {
			this.getSession().flush();
		}

		@Override
		public void clear() {
			this.getSession().clear();
		}

	}



