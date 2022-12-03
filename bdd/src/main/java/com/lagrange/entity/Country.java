package com.lagrange.entity;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    @Column(nullable=false, unique=false)
    private String name;


}
