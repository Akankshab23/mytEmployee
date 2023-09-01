package com.myt.employee.entity;



import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Valid
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long empId;
    @Column(name = "EMP_FIRST_NAME",length = 40)
    @NotNull
    @Size( min=3,max=40,message = "Name should be grater than 3 and  less then 40 characters")
    private String empFirstName;
    @Column(name = "EMP_LAST_NAME",length = 40,nullable = false)
    private String empLastName;
    @Column(name = "EMP_EMAIL",unique = true)
    private String empEmail;
    @Column(name = "EMP_DOJ",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date doj;
    @Column(name = "EMP_SALARY",nullable = false)
    private double salary;
    @Column(name = "DEP_ID") // Name of the column in EMPLOYEE table referencing the DEPARTMENT table
    private Long departmentId;

}
