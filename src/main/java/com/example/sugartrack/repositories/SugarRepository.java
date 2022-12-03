package com.example.sugartrack.repositories;

import com.example.sugartrack.entities.Patient;
import com.example.sugartrack.entities.Sugar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugarRepository extends JpaRepository<Sugar,Long>{

    List<Sugar> findSugarBypID(Long id);
}
