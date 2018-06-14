package by.prostrmk.model.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            return configuration.configure()
                    .buildSessionFactory(
                            new StandardServiceRegistryBuilder()
                                    .applySettings(configuration.getProperties())
                                    .build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    private static SessionFactory sessionFactory = null;
//    static {
//        try {
////            sessionFactory em = getSessionFactory().openSession();
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    public static String hashString(String stringForHashing){
        return DigestUtils.md5Hex(stringForHashing);
    }

}
