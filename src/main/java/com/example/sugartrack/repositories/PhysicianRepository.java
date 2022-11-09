package com.example.sugartrack.repositories;
import com.example.sugartrack.entities.Physician;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhysicianRepository extends JpaRepository<Physician, Long>{
}
