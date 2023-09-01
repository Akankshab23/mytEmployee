package com.myt.employee.model;

import com.myt.employee.entity.DepartmentEntity;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private Long empId;

    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private Date doj;
    private double salary;
    private Long departmentId;
}
