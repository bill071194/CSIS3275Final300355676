package com.example.sugartrack.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pID;
    private String password;
    private String first_name;
    private String last_name;
    private char gender;
    private String phone_number;
    private String country_code;
    private String state_province;
    private String Address;
    private String email_address;
    private float height;
    private float weight;
    private int meals_per_day;
    private int fav_food;
    private int exercise;
    private int exercise_duration;
    private String pregnancy_status;
    private String emergency_first_name;
    private String emergency_last_name;
    private String emergency_phone;
    private String emergency_email;
    private String subscription_status;
}
