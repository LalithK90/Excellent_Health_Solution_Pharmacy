package com.excellenthealthSolution.pharmacy.resourse.companyResource.dao;

import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
}
