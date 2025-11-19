package models;

//***This class is storing information key to the Researcher/User***
public class Researcher {

    private String fullName;
    private String email;
    private String password;

    //This is the class constructor
    public Researcher(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    //Get and set is reading and updating the relevant fields
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }
}