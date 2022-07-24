package web.model;


public class User {

    private long id;


    private String name;


    private String LastName;


    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        LastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }


    public User(String firstName, String lastName, String email) {
        this.name = firstName;
        this.LastName = lastName;
        this.email = email;
    }
}
