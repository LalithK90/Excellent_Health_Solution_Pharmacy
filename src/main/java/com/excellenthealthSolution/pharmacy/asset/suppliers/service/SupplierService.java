package com.excellenthealthSolution.pharmacy.asset.suppliers.service;

import com.excellenthealthSolution.pharmacy.util.interfaces.AbstractService;
import com.excellenthealthSolution.pharmacy.asset.suppliers.entity.Supplier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class SupplierService implements AbstractService<Supplier, Long> {



    public List<Supplier> findAll() {
        return null;
    }


    public Supplier findById(Long id) {
        return null;
    }


    public Supplier persist(Supplier supplier) {
        return null;
    }


    public boolean delete(Long id) {
        return false;
    }


    public List<Supplier> search(Supplier supplier) {
        return null;
    }
}
