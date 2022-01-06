package com.example.sportsappbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="player_interested_sports")
public class InterestedSports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "player_k_player_id", nullable = false)
    private long playerID;

    @Column(name = "interested_sports", nullable = false)
    private int interestedSports;
}
