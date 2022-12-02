package com.example.sugartrack.web;

import com.example.sugartrack.entities.Food;
import com.example.sugartrack.entities.Patient;
import com.example.sugartrack.entities.Physician;
import com.example.sugartrack.entities.Sugar;
import com.example.sugartrack.repositories.FoodRepository;
import com.example.sugartrack.repositories.PatientRepository;
import com.example.sugartrack.repositories.PhysicianRepository;
import com.example.sugartrack.repositories.SugarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
class AppControllerTest {

    Food food;
    Patient patient;
    Physician physician;
    Sugar sugar;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    FoodRepository foodRepository;
    @Mock
    PatientRepository patientRepository;
    @Mock
    PhysicianRepository physicianRepository;
    @Mock
    SugarRepository sugarRepository;

    @Mock
    View mockView;

    @InjectMocks
    AppController appController;

    @BeforeEach
    void setup() {
        patient = new Patient();
        patient.setPID(1L);
        patient.setEmailaddress("johndoe@gmail.com");
        patient.setPassword("123456");
        patient.setFirstname("John");
        patient.setLastname("Doe");
        patient.setGender('M');
        patient.setPhonenumber("8888888888");
        patient.setCountrycode("1");
        patient.setStateprovince("BC");
        patient.setAddress("700 Royal Ave, New Westminster, BC");
        patient.setHeight((float) 1.83);
        patient.setWeight((float) 80.0);
        patient.setMealsperday(3);
        patient.setFavfood(1);
        patient.setExercise(1);
        patient.setExerciseduration(30);
        patient.setPregnancystatus("N");
        patient.setEmergencyfirstname("Jane");
        patient.setEmergencylastname("Doe");
        patient.setEmergencyphone("6666666666");
        patient.setEmergencyemail("janedoe@gmail.com");
        patient.setSubscriptionstatus("Y");


        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(appController).setSingleView(mockView).build();
    }

    @Test
    void signin() {
    }

    @Test
    void signup() {
    }

    @Test
    void doctor_signup() {
    }

    @Test
    void savePatient() throws Exception {
        when(patientRepository.save(patient)).thenReturn(patient);
        patientRepository.save(patient);
        verify(patientRepository,times(1)).save(patient);
    }

    @Test
    void saveDoctor() {
    }

    @Test
    void deletePatient() {
    }

    @Test
    void editpatient() {
    }

    @Test
    void saveEditPatient() {
    }

    @Test
    void deletePhysician() {
    }

    @Test
    void editphysician() {
    }

    @Test
    void saveEditPhysician() {
    }

    @Test
    void saveSugar() {
    }

    @Test
    void saveCarbs() {
    }
}