package com.example.jpql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpRepo extends CrudRepository<Employee,Integer> {

    @Query("From Employee")
    List<Employee> findAllEmployee();

    @Query("select firstName,lastName from Employee")
    List<Object[]> findAllEmployeePartial();

    @Query(" SELECT firstName, lastName FROM Employee" +
            " WHERE salary > (SELECT AVG(salary) FROM Employee) " +
            " ORDER BY age ASC ,salary DESC")
    List<Object[]> findEmployeesWithSalaryGreaterThanAverage();



    @Query("select AVG(salary) from Employee")
    Integer avg();

    @Transactional
    @Modifying
    @Query("UPDATE Employee  SET salary = :newSalary " +
            " WHERE salary < :avg")
    void updateSalaryLessThanAvg(@Param("newSalary") int newSalary,@Param("avg") Integer avg);


    @Query("(SELECT MIN(salary) FROM Employee)")
    Integer min();
    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary = :min")
    void deleteEmployeesWithMinimumSalary(@Param("min") Integer min);


    // >>>>>>>>>>>>>>>>>>>>>>>>>>> NATIVE QUERIES <<<<<<<<<<<<<<<<<<<<<<<<< //

    @Query(value = "select * from employeetable",nativeQuery = true)
    List<Employee> findAllEmployeeNative();

    @Query(value = "SELECT empId, empFirstName, empAge " +
            "FROM employeetable WHERE empLastName LIKE '%singh'", nativeQuery = true)
    List<Object[]> findEmployeesWithSinghLastName();


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM employeetable WHERE empAge > :age", nativeQuery = true)
    void deleteEmployeesByAge(@Param("age") int age);


}
