package contacts.model;

/**
 * Created by jorgeotero on 5/29/17.
 */
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long phone;

    public Contact(String firstName, String lastName, String email, long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String toString() {
        return String.format("%s %s (%d)", firstName, lastName, id);
    }
}