package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private String male;

    @Column
    private String email;

    @Column
    private Date birthday;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String schoolyear;
    @Column
    private String department;

    @Column
    private String role;

    public User() {
    }

    public User(String username, String password, String fullname, String male, String email, Date birthday, String address, String phone, String schoolyear, String department, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.male = male;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.schoolyear = schoolyear;
        this.department = department;
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }
}