package com.kenmeister.comprehensiveApplication.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "JOB_TARGET")
public class JobTargetEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;
}
