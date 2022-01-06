package com.example.sportsappbackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="k_team_members")
public class TeamMember {
    @Id
    private long k_team_members_id;

    @Column(name = "k_team_id", nullable = false)
    private long teamID;

    @Column(name = "k_player_id", nullable = false)
    private long playerID;


}
