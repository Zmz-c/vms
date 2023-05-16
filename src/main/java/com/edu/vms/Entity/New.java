package com.edu.vms.Entity;

import jakarta.persistence.*;
import lombok.Data;

/*
新闻表
 */
@Data
@Entity
@Table(name = "New")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "NewText")
    private String NewText;
    @Column(name = "NewTitle")
    private String NewTitle;
    @Column(name = "NewAuthor")
    private String NewAuthor;

}
