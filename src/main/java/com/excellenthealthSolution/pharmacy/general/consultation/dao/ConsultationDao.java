package com.excellenthealthSolution.pharmacy.general.consultation.dao;

import com.excellenthealthSolution.pharmacy.general.consultation.entity.Consultations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationDao extends JpaRepository<Consultations, Integer> {
}
