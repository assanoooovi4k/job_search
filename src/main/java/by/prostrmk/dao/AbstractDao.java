package by.prostrmk.dao;

import by.prostrmk.model.entity.IEntity;
import by.prostrmk.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao implements Dao{

    @Override
    public IEntity getById(Long id, Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("id", id));
        return (IEntity) criteria.uniqueResult();
    }

    @Override
    public IEntity getByStringParamUnique(String paramName, String paramValue, Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq(paramName, paramValue));
        return (IEntity) criteria.uniqueResult();
    }

    @Override
    public List getByStringParamList(String paramName, String paramValue, Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq(paramName,paramValue));
        return criteria.list();
    }

    @Override
    public List getAll(String param, Class clazz) {
        return HibernateUtil.getSessionFactory().openSession().createCriteria(clazz).list();

    }

    @Override
    public List getLatest(String tableName, int count) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("SELECT * FROM " + tableName + "ORDER BY id DESC").setMaxResults(count).list();

    }

    @Override
    public void saveEntity(IEntity entity) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }catch (Exception e){
//            LOGGER.error(e);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void deleteEntity(IEntity entity) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }catch (Exception e){
//            LOGGER.error(e);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateEntity(IEntity entity) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }catch (Exception e){
//            LOGGER.error(e);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List search(String column,String table, String searchString) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = new StringBuilder().append("FROM ").append(table).append(" WHERE ").append(column).append(" LIKE '%").append(searchString).append("%'").toString();//
            Query query = session.createQuery(hql);//
            return query.list();
        } catch (Exception e) {
//            logger.error("Search Error");
            return new ArrayList();
        } finally {
            assert session != null;
            session.close();
        }
    }


}
