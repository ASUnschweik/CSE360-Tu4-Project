package ProjectThree;

import java.time.LocalDate;

public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate dateOfBirth;
    private UserType userType;

    // Enum for user types
    public enum UserType {
        PATIENT, DOCTOR, NURSE
    }

    // Default constructor
    public User() {
    }

    // Specific constructor
    public User(String email, String firstName, String lastName, String password, LocalDate dateOfBirth, UserType userType) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String E) {
        this.email = E;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FN) {
        this.firstName = FN;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LN) {
        this.lastName = LN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String PW) {
        this.password = PW;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate DOB) {
        this.dateOfBirth = DOB;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType UT) {
        this.userType = UT;
    }
    
    public String toString() {
        return "User Type: " + userType +
                "\nEmail:" + email +
                "First Name: " + firstName + 
                "Last Name: " + lastName +
                "Password: " + password + 
                "Date Of Birth: " + dateOfBirth;
    }
}
