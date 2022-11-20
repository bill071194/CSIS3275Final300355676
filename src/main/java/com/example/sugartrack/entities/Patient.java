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
    private String emailaddress;
    private String password;
    private String firstname;
    private String lastname;
    private char gender;
    private String phonenumber;
    private String countrycode;
    private String stateprovince;
    private String Address;
    private float height;
    private float weight;
    private int mealsperday;
    private int favfood;
    private int exercise;
    private int exerciseduration;
    private String pregnancystatus;
    private String emergencyfirstname;
    private String emergencylastname;
    private String emergencyphone;
    private String emergencyemail;
    private String subscriptionstatus;
}
