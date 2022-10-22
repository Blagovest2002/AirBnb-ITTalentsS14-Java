package com.ittalents.airbnb.model.entity;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private  String phoneNumber;
    @Column
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column
    LocalDate dateOfBirth;
    @Column
    private String profilePictureUrl;
    @Column
    @JsonProperty("isHost")
    private boolean isHost;
    @OneToMany(mappedBy = "host")
    private List<Property> properties;
    @OneToMany(mappedBy = "user")
    Set<Reservation> reservations;
    @OneToMany(mappedBy = "user")
    Set<Review> reviews;
    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "wish_user_id"),
            inverseJoinColumns = @JoinColumn(name = "wish_property_id"))
    Set<Property> wishlist;
}
