package zioo.top.educ.server;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseService<Model,Primary extends Serializable> {
	
	@Resource
	SessionFactory sessionFactory;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	Class<?> entityClass;
	
	public BaseService() {
		Type type = getClass().getGenericSuperclass();
		if(!(type instanceof ParameterizedType)){
		    type = getClass().getSuperclass().getGenericSuperclass();
		}
		entityClass = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
//		entityClass= (Class<?>)(parameterizedType.getActualTypeArguments()[0]); 
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	Model get(Primary id) {
		return (Model) getSession().get(entityClass, id);
	}
	
	void delete(Primary id) {
		getSession().delete(this.get(id));
	}
	
	void save(Model model) {
		getSession().save(model);
	}
	
	void update(Model model) {
		getSession().update(model);
	}
	
	@SuppressWarnings("unchecked")
	List<Model> list() {
		return createQuery("from " + entityClass.getSimpleName()).list();
	}
	
	Query createQuery(String hql){
		return getSession().createQuery(hql);
	}
}
