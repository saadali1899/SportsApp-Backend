package com.example.sportsappbackend.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="k_player")
public class Player {
    @Id
    private long k_player_id;

    @Column(name = "isactive", nullable = false)
    private char isactive;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false)
    private Timestamp updated;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname", nullable = false)
    private String laname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_no", nullable = false)
    private String phone_no;

    @ElementCollection
    @Column(name = "interested_sports", nullable = false)
    private List<Integer> interested_sports;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_address", nullable = false)
    private String image_address;
}
