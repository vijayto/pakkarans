package com.example.pakkarans.entity;

import javax.persistence.*;

@Entity
@Table(name = DemoEntity.DEMO_ENTITY)
public class DemoEntity {

    public static final String DEMO_ENTITY = "DEMO_ENTITY" ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "message")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
