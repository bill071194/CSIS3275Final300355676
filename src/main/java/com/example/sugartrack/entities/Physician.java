package com.example.sugartrack.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phID;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String Address;
    private String email_address;
    private String licence_number;
}
