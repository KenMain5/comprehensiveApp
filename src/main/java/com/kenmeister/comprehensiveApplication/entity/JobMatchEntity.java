package com.kenmeister.comprehensiveApplication.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "JOB_MATCH")
public class JobMatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String name;

    private Timestamp dateFound;

    private Long referenceId;
}
