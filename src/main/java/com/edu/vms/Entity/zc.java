package com.edu.vms.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "zc")
public class zc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "zcText")
    private String zcText;
    @Column(name = "zcTitle")
    private String zcTitle;
    @Column(name = "zcAuthor")
    private String zcAuthor;

}