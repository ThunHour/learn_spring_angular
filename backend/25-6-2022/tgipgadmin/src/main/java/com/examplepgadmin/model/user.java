package com.examplepgadmin.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class user {
    public user(String id, String firstrname, String lastname, String gender, String password, Date createdate,
            String status) {
        this.id = id;
        this.firstname = firstrname;
        this.lastname = lastname;
        this.gender = gender;
        this.password = password;
        this.createdate = createdate;
        this.status = status;
    }
    public user(){}

    @Id
    @Column(name="id")
    private String id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name="gender")
    private String gender;
    @Column(name="password")
    private String password;
    @Column(name="created_date")
    private Date createdate;
    @Column(name="status")
    private String status;

}
