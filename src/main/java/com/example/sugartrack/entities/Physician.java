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
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String address;
    private String emailaddress;
    private String licencenumber;
}
