package by.prostrmk.model.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    static {
        try {
//            sessionFactory = getSessionFactory().openSession();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(":(");
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static String hashString(String stringForHashing){
        return DigestUtils.md5Hex(stringForHashing);
    }

}
