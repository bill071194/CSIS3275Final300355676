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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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

        physician = new Physician();
        physician.setPhID(1L);
        physician.setPassword("123456");
        physician.setFirstname("Doc");
        physician.setLastname("Ock");
        physician.setPhonenumber("1234567890");
        physician.setAddress("123 ABC Ave");
        physician.setEmailaddress("docock@marvel.com");
        physician.setLicencenumber("12345");

        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(appController).setSingleView(mockView).build();
    }

    @Test
    void savePatient() throws Exception {
        when(patientRepository.save(patient)).thenReturn(patient);
        patientRepository.save(patient);
        verify(patientRepository,times(1)).save(patient);
    }

    @Test
    void saveDoctor() {
        when(physicianRepository.save(physician)).thenReturn(physician);
        physicianRepository.save(physician);
        verify(physicianRepository,times(1)).save(physician);
    }

    @Test
    void deletePatient() throws Exception {
        ArgumentCaptor<Long> idCapture = ArgumentCaptor.forClass(Long.class);
        doNothing().when(patientRepository).deleteBypID(idCapture.capture());
        patientRepository.deleteBypID(1L);
        assertEquals(1L,idCapture.getValue());
        verify(patientRepository,times(1)).deleteBypID(1L);
    }

    @Test
    void saveEditPatient() throws Exception {
//        List<Patient> p2 = new ArrayList<Patient>();
//
//        Patient p = new Patient();
//
//        p.setPID(1L);
//        p.setEmailaddress("johndoe@gmail.com");
//        p.setPassword("123456");
//        p.setFirstname("John");
//        p.setLastname("Mast");
//        p.setGender('M');
//        p.setPhonenumber("8888888888");
//        p.setCountrycode("1");
//        p.setStateprovince("BC");
//        p.setAddress("700 Royal Ave, New Westminster, BC");
//        p.setHeight((float) 1.83);
//        p.setWeight((float) 80.0);
//        p.setMealsperday(3);
//        p.setFavfood(1);
//        p.setExercise(1);
//        p.setExerciseduration(30);
//        p.setPregnancystatus("N");
//        p.setEmergencyfirstname("Jane");
//        p.setEmergencylastname("Doe");
//        p.setEmergencyphone("6666666666");
//        p.setEmergencyemail("janedoe@gmail.com");
//        p.setSubscriptionstatus("Y");
//
//        p2.add(p);
//
//        Long iid = 1l;
//
//        when(patientRepository.findPatientBypID(iid)).thenReturn(p2);
//
//        mockMvc.perform(post("/saveeditpatient")
//                        .contentType(MediaType.ALL)
//                        .content(p)
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("patient", p2.get(0)))
//                .andExpect(view().name("adminpatient"));
//
//        verify(patientRepository,times(1)).findPatientBypID(anyLong());
//        verifyNoMoreInteractions(patientRepository);
    }

    @Test
    void deletePhysician() {
        ArgumentCaptor<Long> idCapture = ArgumentCaptor.forClass(Long.class);
        doNothing().when(physicianRepository).deleteByphID(idCapture.capture());
        physicianRepository.deleteByphID(1L);
        assertEquals(1L,idCapture.getValue());
        verify(physicianRepository,times(1)).deleteByphID(1L);
    }

    @Test
    void saveEditPhysician() {
    }

    @Test
    void saveSugar() {
        when(sugarRepository.save(sugar)).thenReturn(sugar);
        sugarRepository.save(sugar);
        verify(sugarRepository,times(1)).save(sugar);
    }

    @Test
    void saveCarbs() {
        when(foodRepository.save(food)).thenReturn(food);
        foodRepository.save(food);
        verify(foodRepository,times(1)).save(food);
    }

    @Test
    void signin() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().isOk())
                .andExpect(view().name("signin"));
    }

    @Test
    void signup() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("patient", new Patient()))
                .andExpect(view().name("signup"));
    }

    @Test
    void doctor_signup() throws Exception{
        mockMvc.perform(get("/doctor_signup"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("physician", new Physician()))
                .andExpect(view().name("doctor_signup"));
    }

    @Test
    void adminhome() throws Exception {
        mockMvc.perform(get("/adminhome"))
                .andExpect(status().isOk())
                .andExpect(view().name("adminhome"));
    }
}