import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {

       Session session = HibernateConfig.getSession();

       try{
           User us = new User("Adarsh");
           session.beginTransaction();
           try{
               session.persist(us);
           }catch (Exception e){
               e.printStackTrace();
           }
           session.getTransaction().commit();
           System.out.println("User Saved"+ us.getId());

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           HibernateConfig.Close();
       }

    }

}
