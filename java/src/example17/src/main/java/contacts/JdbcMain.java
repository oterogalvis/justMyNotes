package contacts;

import contacts.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jorgeotero on 5/29/17.
 */

public class JdbcMain {
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO: Load the SQLite JDBC driver (JDBC class implements java.sql.Driver)
        Class.forName("org.sqlite.JDBC");
        // TODO: Create a DB connection
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:contactmgr0.db")) {

            // TODO: Create a SQL statement
            Statement statement = connection.createStatement();

            // TODO: Create a DB table
            statement.executeUpdate("DROP TABLE IF EXISTS contacts");
            statement.executeUpdate("CREATE TABLE contacts (" +
                    "id INTEGER PRIMARY KEY, firstname STRING, lastname STRING, email STRING, phone INT(10))");

            // TODO: Insert a couple contacts
            Contact contact = new Contact("Jorge", "Otero", "oterogalvis@gmail.com", 5555555555L);
            save(contact, statement);
            contact = new Contact("Jesus", "Maldonado", "jesus.javier.m@gmail.com", 5555555555L);
            save(contact, statement);

            // TODO: Fetch all the records from the contacts table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");

            // TODO: Iterate over the ResultSet & display contact info
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");

                System.out.printf("%s %s (%d)%n", firstname, lastname, id);
            }

        } catch (SQLException ex) {
            // Display connection or query errors
            System.err.printf("There was a database error: %s%n",ex.getMessage());
        }
    }

    public static void save(Contact contact, Statement statement) throws SQLException{
        String sqlForInsert = "INSERT INTO contacts (firstname, lastname, email, phone) VALUES('%s','%s','%s',%d)";
        sqlForInsert = String.format(sqlForInsert, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());

        statement.executeUpdate(sqlForInsert);
    }
}
