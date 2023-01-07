import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DogDAO {

    private static SessionFactory factory;

    public DogDAO() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Could not connect to the DB");
        }
    }

    public Dog saveDog(Dog dog) {
        System.out.println(dog.getName());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(dog);
        transaction.commit();
        session.close();
        dog.setId(id);
        return dog;
    }

    public List<Dog> getBreeds() {
        Session session = factory.openSession();

        Query<Dog> query = session.createQuery("SELECT b FROM Dog b", Dog.class);
        List<Dog> results = query.getResultList();

        return results;
    }


}
