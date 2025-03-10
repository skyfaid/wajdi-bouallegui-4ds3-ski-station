package tn.esprit.wajdibouallegui4ds3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.wajdibouallegui4ds3.entities.Registration;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {

}
