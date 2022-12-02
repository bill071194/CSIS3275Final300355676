package com.example.sugartrack.repositories;

import com.example.sugartrack.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientByemailaddress(String emailaddress);
    List<Patient> findPatientBypID(Long pID);
    List<Patient> deleteBypID(Long id);

}
