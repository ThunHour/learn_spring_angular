package com.oopservice.oop_service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "tbl_item")
public class Item {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
    @Column(name = "pic")
    private String pic;
    @Column(name = "price")
    private float price;
    @Column(name = "create_date")
    private Date createdate;
    @Column(name = "status")
    private String status;

    public Item() {
    }

    public Item(String id, String name, String pic, float price, String status, Date createdate) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.status = status;
        this.createdate = createdate;
    }

}
