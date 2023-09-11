package task_3;

import java.time.LocalDate;

public class User {

    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private Sex sex;

    public User(String lastName, String firstName, String middleName, LocalDate dateOfBirth,
                    long phoneNumber, Sex sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }
}