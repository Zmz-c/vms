package com.edu.vms.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "VMSUG")
public class VMSUG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //活动id
    @Column(name = "VMname")
    private String VMname; //活动名称
    @Column(name = "VMT")
    private  String VMT; //活动内容
    @Column(name = "vmAdders")
    private  String vmAdders; //活动地址
    @Column(name = "vmN")
    private  String vmN;  //活动发起人
    @Column(name = "isvm")
    private  String isvm;  //所属项目组
    @Column(name = "isuser")
    private  String isuser;  //所属用户

}
