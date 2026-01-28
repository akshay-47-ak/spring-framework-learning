import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {

       Session session = HibernateConfig.getSession();

       try{
           users us = new users("Adarsh");
           session.beginTransaction();
           session.persist(us);
           session.getTransaction().commit();
           System.out.println("User Saved"+ us.getId());

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           HibernateConfig.Close();
       }

    }

}
