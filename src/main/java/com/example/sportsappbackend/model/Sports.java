package com.example.sportsappbackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="k_sports")
public class Sports {
    @Id
    private long k_sports_id;

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

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "issummary", nullable = false)
    private char isSummary;

    @Column(name = "member_count", nullable = false)
    private int member_count;

    @Column(name = "image_address", nullable = false)
    private String image_address;
}
