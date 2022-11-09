package com.example.sugartrack.repositories;

import com.example.sugartrack.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
