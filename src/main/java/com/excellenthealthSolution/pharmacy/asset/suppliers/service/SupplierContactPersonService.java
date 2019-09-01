package com.excellenthealthSolution.pharmacy.asset.suppliers.service;

import com.excellenthealthSolution.pharmacy.util.interfaces.AbstractService;
import com.excellenthealthSolution.pharmacy.asset.suppliers.entity.SupplierContactPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierContactPersonService implements AbstractService<SupplierContactPerson, Integer> {
    @Override
    public List<SupplierContactPerson> findAll() {
        return null;
    }

    @Override
    public SupplierContactPerson findById(Integer id) {
        return null;
    }

    @Override
    public SupplierContactPerson persist(SupplierContactPerson supplierContactPerson) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<SupplierContactPerson> search(SupplierContactPerson supplierContactPerson) {
        return null;
    }
}
