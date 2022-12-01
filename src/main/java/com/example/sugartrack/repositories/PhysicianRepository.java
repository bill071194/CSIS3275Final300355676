package com.example.sugartrack.repositories;
import com.example.sugartrack.entities.Patient;
import com.example.sugartrack.entities.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhysicianRepository extends JpaRepository<Physician, Long>{
    List<Physician> findPhysicianByemailaddress(String emailaddress);

    List<Physician> findPhysicianByphID(Long phID);
    List<Physician> deleteByphID(Long id);
}
