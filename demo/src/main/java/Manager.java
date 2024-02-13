import jakarta.persistence.*;

@Entity
@Table(name = "MANAGER")
public class Manager {

    /** generates a random id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // everything else that we want to define inside the columns
    @Column(name = "Manager's First Name")
    private String firstName;

    @Column(name = "Manager's Last Name")
    private String lastName;

    public Manager(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

}
