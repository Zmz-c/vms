package com.edu.vms.Entity;
import jakarta.persistence.*;
import lombok.Data;

/*
管理登录
 */
@Data
@Entity
@Table(name = "AdminUser")
public class AdminUser {
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

}
