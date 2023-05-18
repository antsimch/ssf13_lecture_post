package sg.edu.nus.iss.ssf13_lecture_post.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {

    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 64, message = "Name should be between 3 to 64 characters")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Tel No. is mandatory")
    @Size(min = 8, message = "Invalid phone number")
    private String telNo;

    @Past(message = "Date of birth should not be from the future")
    @NotNull(message = "Date of birth is mandatory")
    @DateTimeFormat(pattern = "mm-dd-yyyy")
    private LocalDate dateOfBirth;

    @Min(value = 10, message = "Must be at least 10 years old")
    @Max(value = 100, message = "Must be below 100 years old")
    private int age;

    private String id;

    private final int ID_LENGTH = 8;

    private final int HEX_MAX = 15;

    public Contact() {
        this.id = generateID();
    }

    public Contact(String name, String email, String telNo) {
        this.name = name;
        this.email = email;
        this.telNo = telNo;
    }

    public String generateID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < ID_LENGTH) {
            sb.append(Integer.toHexString(random.nextInt(HEX_MAX)));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", email=" + email + ", telNo=" + telNo + ", dateOfBirth=" + dateOfBirth + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        int calculatedAge = 0;

        if (dateOfBirth != null) {
            calculatedAge = Period.between(dateOfBirth, LocalDate.now()).getYears();
        }

        this.age = calculatedAge;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   
}
