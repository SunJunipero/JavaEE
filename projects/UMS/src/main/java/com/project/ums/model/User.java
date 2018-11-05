package com.project.ums.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "users")
@XmlRootElement(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "user_first_name")
    private String user_first_name;
    @Column(name = "user_last_name")
    private String user_last_name;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;
    @Column(name = "is_active")
    private boolean is_active;
    @Column(name = "created_stamp", nullable = true, insertable = true, updatable = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_stamp;
    @Column(name = "last_updated_stamp", nullable = true, insertable = true, updatable = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date last_updated_stamp;
    @Column(name = "address")
    private String address;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

//    @PrePersist
//    protected void updateBirthday(){
//        birthday.setTime(birthday.getTime());
//    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreated_stamp() {
        return created_stamp;
    }

    public void setCreated_stamp(Date created_stamp) {
        this.created_stamp = created_stamp;
    }



    public Date getLast_updated_stamp() {
        return last_updated_stamp;
    }

    public void setLast_updated_stamp(Date last_updated_stamp) {
        this.last_updated_stamp = last_updated_stamp;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", is_active=" + is_active +
                ", created_stamp=" + created_stamp +
                ", last_updated_stamp=" + last_updated_stamp +
                ", address='" + address + '\'' +
                '}';
    }
}
