package com.edu.vms.Entity;
import jakarta.persistence.*;
import lombok.Data;

/*
用户登录
 */
@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "sex")
    private String sex;
    @Column(name = "phoneName")
    private String phoneName;
    @Column(name = "zyz")
    private String zyz;
    @Column(name = "zyxm")
    private String zyxm;
    @Column(name = "grjj")
    private String grjj;
}
