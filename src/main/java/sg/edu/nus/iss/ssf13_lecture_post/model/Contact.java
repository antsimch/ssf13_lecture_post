package sg.edu.nus.iss.ssf13_lecture_post.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Contact {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 3, max = 15, message = "Name should be between 3 to 15 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    @Size(min = 8, message = "Invalid phone number")
    private String telNo;

    public Contact() {
    }

    public Contact(String name, String email, String telNo) {
        this.name = name;
        this.email = email;
        this.telNo = telNo;
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
}
