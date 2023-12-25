package mycode.demo2.student;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private final UUID studentId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    enum Gender {MALE, FEMALE}

    public Student( 
        //we will map all json properties that comefrom the client 
        @JsonProperty("studentId") UUID studentId, @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, 
        @JsonProperty("gender") Gender gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
    }
}