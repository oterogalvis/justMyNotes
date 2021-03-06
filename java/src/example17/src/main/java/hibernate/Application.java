package hibernate;

import hibernate.model.Contact;
import hibernate.model.Contact.ContactBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Created by jorgeotero on 5/30/17.
 */
public class Application {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    private static int save(Contact contact) {
//        Open a Session
        Session session = sessionFactory.openSession();
//        Begin a transaction
        session.beginTransaction();
//        Use the session to save the contact
        int id = (int) session.save(contact);
//        Commit the transaction
        session.getTransaction().commit();
//        Close the session
        session.close();
        return id;
    }

    @SuppressWarnings("unchecked")
    private static List<Contact> fetchAllContacts() {
//        Open a Session
        Session session = sessionFactory.openSession();
//        Create Criteria
        Criteria criteria = session.createCriteria(Contact.class);
//        Get a list of Contact objects according to the Criteria object
        List<Contact> contacts = criteria.list();
//        Close the session
        session.close();
        return contacts;
    }

    private static Contact findContactById(int id) {
//        Open a session
        Session session = sessionFactory.openSession();
//        Retrieve the persistent object (or null if not found)
        Contact contact = session.get(Contact.class, id);
//        Close the session
        session.close();
//        Return the object
        return contact;
    }

    private static void update(Contact contact) {
//        Open a Session
        Session session = sessionFactory.openSession();
//        Begin a transaction
        session.beginTransaction();
//        Use the session to update the contact
        session.update(contact);
//        Commit the transaction
        session.getTransaction().commit();
//        Close the session
        session.close();
    }

    private static void delete(Contact contact) {
//        Open a session
        Session session = sessionFactory.openSession();
//        Begin a transaction
        session.beginTransaction();
//        Use the session to update the contact
        session.delete(contact);
//        Commit the transaction
        session.getTransaction().commit();
//        Close the session
        session.close();
    }

    public static void main(String[] args) {
        Contact contact = new ContactBuilder("Jorge", "Otero")
                .withEmail("oterogalvis@gmail.com").withPhone(5555555555L).build();

        int id = save(contact);

//        Display a list of contacts before the update
        System.out.printf("%n%nBefore update%n%n");
        fetchAllContacts().forEach(System.out::println);
//        Get the persisted contact
        Contact c = findContactById(id);
//        Update the contact
        c.setFirstName("Beatrix");
//        Persist the changes
        System.out.printf("%n%nUpdating...%n%n");
        update(c);
        System.out.printf("%n%nUpdate complete!%n%n");
//        Display a list of contacts after the update
        System.out.printf("%n%nAfter update%n%n");
        fetchAllContacts().forEach(System.out::println);

        System.out.printf("%n%nDeleting...%n%n");
        delete(findContactById(1));
        System.out.printf("%n%nDelete complete!%n%n");
//        Display a list of contacts after the delete
        System.out.printf("%n%nAfter delete%n%n");
        fetchAllContacts().forEach(System.out::println);
    }
}
