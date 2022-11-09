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
    public String savePatient(Model model, Patient patient, BindingResult bindingResult, ModelMap mm, HttpSession session){
        if (bindingResult.hasErrors()){
            return "signup";
        }else{
            patientRepository.save(patient);
            if (num==2){
                mm.put("e", 2);
                mm.put("a",0);
            }else{
                mm.put("a",1);
                mm.put("e",0);
            }
            return "redirect:signin";
        }
    }

    @PostMapping(path="/savedoctor")
    public String saveDotor(Model model, Physician physician, BindingResult bindingResult, ModelMap mm, HttpSession session){
        if (bindingResult.hasErrors()){
            return "doctor_signup";
        }else{
            physicianRepository.save(physician);
            if (num==2){
                mm.put("e", 2);
                mm.put("a",0);
            }else{
                mm.put("a",1);
                mm.put("e",0);
            }
            return "redirect:signin";
        }
    }
}
