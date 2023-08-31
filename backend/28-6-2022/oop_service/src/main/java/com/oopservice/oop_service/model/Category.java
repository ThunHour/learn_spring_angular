package com.oopservice.oop_service.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="tbl_category")
public class Category {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="create_date")
    private Date createDate;
    public Category(String id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }
    public Category() {
       
    }
}
