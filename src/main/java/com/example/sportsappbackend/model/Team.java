package com.example.sportsappbackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="k_team")
public class Team {
    @Id
    private long k_team_id;

    @Column(name = "isactive", nullable = false)
    private char isactive;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false)
    private Timestamp updated;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "k_captain_id", nullable = false)
    private long captain_id;

    @Column(name = "team_sport", nullable = false)
    private int team_sport;

    @Column(name = "match_played", nullable = false)
    private int match_played;

    @Column(name = "match_won", nullable = false)
    private int match_won;

    @Column(name = "match_lost", nullable = false)
    private int match_lost;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_address", nullable = false)
    private String image_address;
}
