package com.excellenthealthSolution.pharmacy.asset.employee.dao;


import com.excellenthealthSolution.pharmacy.asset.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDao extends JpaRepository< Employee, Integer> {
    Employee findFirstByOrderByIdDesc();

}
