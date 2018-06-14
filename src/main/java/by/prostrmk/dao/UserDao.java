package by.prostrmk.dao;

import by.prostrmk.model.entity.User;
import by.prostrmk.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDao extends AbstractDao {

    public boolean checkUser(String username){
        User user = new User(username);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", user.getUsername()));
        User baseUser = (User)criteria.uniqueResult();
        try{
            return username.equals(baseUser.getUsername());
        }catch (NullPointerException e){
            return false;
        }
    }

}
