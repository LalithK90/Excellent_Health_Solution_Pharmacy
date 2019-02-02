package com.excellenthealthSolution.pharmacy.resourse.companyResource.dao;

import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    Employee findFirstByOrderByIdDesc();

}
