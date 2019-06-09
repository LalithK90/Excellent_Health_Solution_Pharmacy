package com.excellenthealthSolution.pharmacy.resourses.company.dao;

import com.excellenthealthSolution.pharmacy.resourses.company.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
}
