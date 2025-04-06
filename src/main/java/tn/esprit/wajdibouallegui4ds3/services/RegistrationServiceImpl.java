package tn.esprit.wajdibouallegui4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.wajdibouallegui4ds3.entities.Course;
import tn.esprit.wajdibouallegui4ds3.entities.Registration;
import tn.esprit.wajdibouallegui4ds3.entities.Skier;
import tn.esprit.wajdibouallegui4ds3.entities.TypeCourse;
import tn.esprit.wajdibouallegui4ds3.repositories.ICourseRepository;
import tn.esprit.wajdibouallegui4ds3.repositories.IRegistrationRepository;
import tn.esprit.wajdibouallegui4ds3.repositories.ISkierRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private final ISkierRepository skierRepository;
    private final ICourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return registrationRepository.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }

    @Override
    public List<Registration> retrieveAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur)
                .orElseThrow(() -> new RuntimeException("Skier not found"));
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

    @Override
    @Transactional
    public Registration addRegistrationAndAssignToSkierAndCourse(
            Registration registration,
            Long numSkier,
            Long numCourse) {

        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Check course capacity for collective courses
        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN ||
                course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT) {
            long registrationsCount = registrationRepository.countByCourseNumCourse(numCourse);
            if (registrationsCount >= 6) {
                throw new IllegalStateException("Course is full (max 6 participants)");
            }
        }

        // Check skier age for children courses
        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN) {
            int age = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();
            if (age > 12) {
                throw new IllegalStateException("Skier is too old for children course");
            }
        }

        registration.setSkier(skier);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }
}