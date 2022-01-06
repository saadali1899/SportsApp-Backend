package com.example.sportsappbackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="k_tournament")
public class Tournament {
    @Id
    @Column(name = "k_tournament_id", nullable = false)
    private long tournamentID;

    @Column(name = "k_sports_id", nullable = false)
    private long sportsID;

    @Column(name="isactive",nullable = false)
    private char isActive;

    @Column(name="created",nullable = false)
    private Timestamp created;

    @Column(name="updated",nullable = false)
    private Timestamp updated;

    @Column(name="value",nullable = false)
    private String value;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="start_date",nullable = false)
    private Timestamp startDate;

    @Column(name="end_date",nullable = false)
    private Timestamp endDate;

    @Column(name="is_free",nullable = false)
    private Boolean isFree;

    @Column(name="prize_money",nullable = false)
    private int prizeMoney;

    @Column(name="host_id",nullable = false)
    private long hostID;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_address", nullable = false)
    private String imageAddress;
}
