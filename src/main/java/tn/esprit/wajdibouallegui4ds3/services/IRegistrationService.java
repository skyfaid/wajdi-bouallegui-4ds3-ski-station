package tn.esprit.wajdibouallegui4ds3.services;

import tn.esprit.wajdibouallegui4ds3.entities.Registration;

import java.util.List;

public interface IRegistrationService {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    Registration retrieveRegistration(Long numRegistration);
    void removeRegistration(Long numRegistration);
    List<Registration> retrieveAll();
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
}