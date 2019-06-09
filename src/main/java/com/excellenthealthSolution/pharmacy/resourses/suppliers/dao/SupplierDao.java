package com.excellenthealthSolution.pharmacy.resourses.suppliers.dao;

import com.excellenthealthSolution.pharmacy.resourses.suppliers.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
}
