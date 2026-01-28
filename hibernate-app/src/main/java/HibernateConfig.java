import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
private static SessionFactory sessionFactory;

static {

  try{
      sessionFactory = new Configuration()
              .configure("hibernate.cfg.xml")
              .addAnnotatedClass(users.class)
              .buildSessionFactory();

  }catch (Exception e){
      e.printStackTrace();
  }

}

    public static Session getSession() {
    return sessionFactory.getCurrentSession();
    }

    public static void Close() {
     sessionFactory.close();
    }
}
