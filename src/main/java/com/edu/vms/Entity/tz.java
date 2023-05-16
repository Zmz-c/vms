package com.edu.vms.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "tz")
public class tz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tzText")
    private String tzText;
    @Column(name = "tzTitle")
    private String tzTitle;
    @Column(name = "tzAuthor")
    private String tzAuthor;

}