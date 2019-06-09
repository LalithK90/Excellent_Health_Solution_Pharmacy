package com.excellenthealthSolution.pharmacy.resourses.company.service;

import com.excellenthealthSolution.pharmacy.util.interfaces.AbstractService;
import com.excellenthealthSolution.pharmacy.resourses.company.dao.PatientDao;
import com.excellenthealthSolution.pharmacy.resourses.company.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientService implements AbstractService<Patient, Integer> {
    private final PatientDao patientDao;

    @Autowired
    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }


    public List<Patient> findAll() {
        return patientDao.findAll();
    }


    public Patient findById(Integer id) {
        return patientDao.getOne(id);
    }


    public Patient persist(Patient patient) {
        return patientDao.save(patient);
    }


    public boolean delete(Integer id) {
        patientDao.deleteById(id);
        return false;
    }


    public List<Patient> search(Patient patient) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Patient> patientExample = Example.of(patient, matcher);
        return patientDao.findAll(patientExample);
    }


    public Patient lastPatient(){
        return patientDao.findFirstByOrderByIdDesc();
    }


    public Patient findByNIC(String nic) {
        return patientDao.findByNic(nic);
    }

    public Patient findByNumber(String number) {
        return patientDao.findByNumber(number);
    }
}
