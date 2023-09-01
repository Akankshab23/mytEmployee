package com.myt.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEP_ID")
    private Long id;
    @Column(name = "DEP_NAME",length = 10)
    private String depName;
    @Column(name = "DEP_LOCATION",length = 30)
    private String depLocation;
    @Column(name = "DEP_HEAD",length = 30)
    private String depHead;
}
