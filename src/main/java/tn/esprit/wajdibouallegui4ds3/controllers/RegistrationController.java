package tn.esprit.wajdibouallegui4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wajdibouallegui4ds3.entities.Registration;
import tn.esprit.wajdibouallegui4ds3.services.IRegistrationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final IRegistrationService registrationService;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @GetMapping("/get/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable Long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }

    @DeleteMapping("/delete/{numRegistration}")
    public void removeRegistration(@PathVariable Long numRegistration) {
        registrationService.removeRegistration(numRegistration);
    }

    @GetMapping("/all")
    public List<Registration> retrieveAllRegistrations() {
        return registrationService.retrieveAll();
    }

    @PostMapping("/addToSkier/{numSkieur}")
    public Registration addRegistrationAndAssignToSkier(
            @RequestBody Registration registration,
            @PathVariable Long numSkieur) {
        return registrationService.addRegistrationAndAssignToSkier(registration, numSkieur);
    }

    @PutMapping("/assignToCourse/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(
            @PathVariable Long numRegistration,
            @PathVariable Long numCourse) {
        return registrationService.assignRegistrationToCourse(numRegistration, numCourse);
    }

//    @PostMapping("/addToSkierAndCourse/{numSkier}/{numCourse}")
//    public Registration addRegistrationAndAssignToSkierAndCourse(
//            @RequestBody Registration registration,
//            @PathVariable Long numSkier,
//            @PathVariable Long numCourse) {
//        return registrationService.addRegistrationAndAssignToSkierAndCourse(
//                registration, numSkier, numCourse);
//    }
}