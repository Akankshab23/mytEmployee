package com.myt.employee.repository;

import com.myt.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

   // @Query(value = "select * from EMPLOYEE WHERE EMP_FIRST_NAME = ? ",nativeQuery = true)
   // List<EmployeeEntity> findbyEmpFirstName(String name);

    //Proper Method Naming convention in spring JPA
  /// List<EmployeeEntity> findByEmpFirstName(String name);

    @Query(value = "from EmployeeEntity e WHERE e.empFirstName = :empFirstName")
    List<EmployeeEntity> findbxyEmpFirstName(@Param("empFirstName") String empFirstName);


    List<EmployeeEntity> findByEmpFirstNameLike(String name);


    List<EmployeeEntity> findByDepartmentId(Long depid);
}
