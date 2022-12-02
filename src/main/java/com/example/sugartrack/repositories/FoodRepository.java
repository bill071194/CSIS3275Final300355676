package com.example.sugartrack.repositories;

import com.example.sugartrack.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
