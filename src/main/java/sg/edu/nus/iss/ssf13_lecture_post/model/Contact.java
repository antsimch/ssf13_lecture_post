package sg.edu.nus.iss.ssf13_lecture_post.model;

public class Contact {
    private String name;
    private String email;
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
