package com.myt.employee.validation;

import com.myt.employee.constant.ErrorMessage;
import com.myt.employee.exception.EmployeeException;
import com.myt.employee.model.Employee;

public class ValidateData {

      public static Boolean validateEmployeeData(Employee employee){
          boolean isValid = true;

          if(employee.getEmpFirstName().isEmpty()){
              isValid =false;
              throw new EmployeeException(ErrorMessage.EMPLOYEE_NAME);
          }
          if(employee.getEmpFirstName().length()<3 && employee.getEmpFirstName().length()<=40){
              isValid =false;
              throw new EmployeeException(ErrorMessage.EMPLOYEE_NAME_LENGTH);
          }
          return isValid;
      }

}
