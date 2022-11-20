package com.example.sugartrack.web;

import com.example.sugartrack.entities.Patient;
import com.example.sugartrack.entities.Physician;
import com.example.sugartrack.repositories.PatientRepository;
import com.example.sugartrack.repositories.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes({"a","e"})
@Controller
@AllArgsConstructor
public class AppController {

    private PatientRepository patientRepository;
    private PhysicianRepository physicianRepository;
    static int num=0;

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping(path = "/signup")
    public String signup(Model model) {
        model.addAttribute("patient", new Patient());
        return "signup";
    }

    @GetMapping(path="/about")
    public String about() {
        return "about";
    }

    @GetMapping(path="/doctor_signup")
    public String doctor_signup(Model model) {
        model.addAttribute("physician", new Physician());
        return "doctor_signup";
    }

    @PostMapping(path="/save")
    public String savePatient(Patient patient, BindingResult bindingResult, ModelMap mm){
        if (bindingResult.hasErrors()){
            return "signup";
        }else{
            mm.put("a",4);
            patientRepository.save(patient);
            return "redirect:signin";
        }
    }

    @PostMapping(path="/savedoctor")
    public String saveDotor(Physician physician, BindingResult bindingResult, ModelMap mm){
        if (bindingResult.hasErrors()){
            return "doctor_signup";
        }else{
            mm.put("a", 3);
            physicianRepository.save(physician);
            return "redirect:signin";
        }
    }

    @PostMapping("/loginverify")
    public String verifylogin(Model model, @RequestParam(name = "emailaddress", defaultValue = "")String emailaddress, @RequestParam(name="password", defaultValue = "")String password, ModelMap mm,@RequestParam(name="check", defaultValue = "")String check){
        System.out.println(check);
        if (!check.equals("isADoctor")) {
            List<Patient> patient;
            patient = patientRepository.findPatientByemailaddress(emailaddress);
            if (patient.isEmpty()) {
                mm.put("a", 1);
                return "signin";
            }
            Patient user = patient.get(0);
            if (user.getPassword().equals(password)) {
                mm.put("a", 0);
                model.addAttribute("patient", user);
                return "dashboard";
            } else {
                mm.put("a", 2);
                return "signin";
            }
        }else{
            List<Physician> physician;
            physician = physicianRepository.findPhysicianByemailaddress(emailaddress);
            if (physician.isEmpty()) {
                mm.put("a", 1);
                return "signin";
            }
            Physician user = physician.get(0);
            if (user.getPassword().equals(password)) {
                mm.put("a", 0);
                model.addAttribute("physician", user);
                return "dashboard_doctor";
            } else {
                mm.put("a", 2);
                return "signin";
            }
        }
    }
}
