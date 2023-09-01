package com.myt.employee.controller;

import com.myt.employee.entity.EmployeeEntity;
import com.myt.employee.exception.EmployeeException;
import com.myt.employee.model.Employee;
import com.myt.employee.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
   public static final Logger logger= LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        logger.info("inside controller addEmployee method");
        logger.debug("Employee Info :"+employee.toString());
        try{
        Employee empResponse = employeeService.addEmployee(employee);
            logger.debug("EmpResponse Info :"+empResponse.toString());
        return new ResponseEntity(empResponse, HttpStatus.OK);
    } catch (EmployeeException ex) {
            logger.error("Error Message : ",ex.getMessage());
        return new ResponseEntity(getErrorResponse("404", ex.getMessage()), HttpStatus.NOT_FOUND);
    } catch (Exception ex) {

        return new ResponseEntity(getErrorResponse("500", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
    @GetMapping("/getallemployee")
    public List<Employee> getAllEmployee(){
        logger.info("inside controller getAllEmployee method");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getemployeedepid/{depid}")
    public List<Employee> getEmployeeDepId(@PathVariable("depid") Long depid){
        logger.info("inside controller getAllEmployee method");
        return employeeService.getEmployeeDepId(depid);
    }
    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Long empId){
        logger.info("inside controller getEmployeeById method"+empId);
        return employeeService.getEmployeeById(empId);
    }
    @PutMapping("/update/{empId}")
    public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("empId") Long empId ){
        logger.info("inside controller updateEmployeeById method");
         return employeeService.updateEmpoyee(employee);
    }
    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeeById(@PathVariable("empId") Long empId){
        logger.info("inside controller deleteEmployeeById  method");
        employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/getemployeebyfirstname")
    public List<Employee> getEmployeeByFirstName(@RequestParam("firstName") String firstName){
        return employeeService.getEmployeeByFirstName(firstName);
    }
    @GetMapping("/pagingAndSortingEmployee/{pageNumber}/{pageSize}")
    public Page<EmployeeEntity> employeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return employeeService.getEmployeePagination(pageNumber,pageSize);
    }
    public HashMap<String, String> getErrorResponse(String errorcode, String error) {
        HashMap<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("code", errorcode);
        errorMap.put("msg", error);
        return errorMap;
    }
}
