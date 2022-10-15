package com.ittalents.airbnb.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "addresses")
public class Address {

    @Id
    @Column(name = "id") //add own id to addresses in DB?
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "a_id")
    private Property property;

    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String country;
    @Column
    private int number;
}
