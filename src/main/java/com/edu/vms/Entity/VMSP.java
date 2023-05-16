package com.edu.vms.Entity;
import jakarta.persistence.*;
import lombok.Data;

/*
项目信息
@Author 良缘
@Date 2023/4/25
 */
@Data
@Entity
@Table(name = "VMSP")
public class VMSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "VMname")
    private String VMname;
    @Column(name = "sex")
    private String sex;
    @Column(name = "phoneName")
    private String phoneName;
    @Column(name = "Vmtext")
    private String VMtext;
    @Column(name = "VMLoad")
    private String VMLoad;
    @Column(name = "VMTime")
    private String VMTime;
    @Column(name = "password")
    private String password;


}
