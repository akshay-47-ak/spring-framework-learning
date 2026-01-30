import jakarta.persistence.EntityManager;

public class JpaMain {

    public static void main(String[] args) {

        EntityManager em = JPAUtils.getEntityManager();

       try{
           User1 us = new User1("Adarsh");
           em.getTransaction().begin();
           try{
               em.persist(us);  // save()
           }catch (Exception e){
               e.printStackTrace();
           }
           em.getTransaction().commit();
           System.out.println("User1 Saved"+ us.getId());
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           em.close();
           JPAUtils.close();
       }

    }

}
