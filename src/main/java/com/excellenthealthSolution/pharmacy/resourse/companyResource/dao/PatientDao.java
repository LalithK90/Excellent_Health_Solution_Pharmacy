package com.excellenthealthSolution.pharmacy.resourse.companyResource.dao;

import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface PatientDao extends JpaRepository<Patient, Integer> {
    Patient findFirstByOrderByIdDesc();

    Patient findByNic(String nic);

    Patient findByNumber(String number);
}
