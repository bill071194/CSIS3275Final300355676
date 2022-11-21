package com.example.sugartrack.repositories;

import com.example.sugartrack.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientByemailaddress(String emailaddress);

    List<Patient> deleteBypID(Long id);

}
