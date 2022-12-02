package com.example.sugartrack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sugarID;
    private String sugardate;
    private String time;
    private char activity;
    private char beforeafter;
    private float sugarlevel;
    private String insulin;
    private float units;
    private Long pID;
}
