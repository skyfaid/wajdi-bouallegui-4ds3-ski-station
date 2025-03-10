package tn.esprit.wajdibouallegui4ds3.services;

import tn.esprit.wajdibouallegui4ds3.entities.Registration;

import java.util.List;

public interface IRegistrationService {
    Registration addRegistration (Registration skier);
    Registration updateRegistration (Registration skier);
    Registration retrieveRegistration (Long numSkier);
    void removeRegistration(Long numSkier);
    List<Registration> retrieveAll ();
}
