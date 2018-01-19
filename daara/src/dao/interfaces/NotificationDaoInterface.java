package dao.interfaces;

import java.io.Serializable;
import java.util.List;


public interface NotificationDaoInterface <Notification,Id extends Serializable >{
	
public void persist(Notification entity);
	
	public void update(Notification entity);
	
	public Notification findById(Long id);
	
	public void delete(Notification entity);
	
	public List<Notification> findAll();
	
	public void deleteAll();
}
