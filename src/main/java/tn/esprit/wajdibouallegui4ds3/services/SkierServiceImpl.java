package tn.esprit.wajdibouallegui4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.wajdibouallegui4ds3.entities.Piste;
import tn.esprit.wajdibouallegui4ds3.entities.Skier;
import tn.esprit.wajdibouallegui4ds3.entities.Subscription;
import tn.esprit.wajdibouallegui4ds3.entities.TypeSubscription;
import tn.esprit.wajdibouallegui4ds3.repositories.IPisteRepository;
import tn.esprit.wajdibouallegui4ds3.repositories.ISkierRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class SkierServiceImpl implements ISkierService {

    @Autowired
    private ISkierRepository skierRepository;
    @Autowired
    private IPisteRepository pisteRepository;
    @Autowired
    private IPisteService pisteService;

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);
    }

    @Override
    public List<Skier> retrieveAll() {
        return skierRepository.findAll();
    }
    @Override
    @Transactional
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));
        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste not found"));

        skier.getPistes().add(piste);
        return skierRepository.save(skier);
    }

    @Override
    @Transactional
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        // Create and save subscription
        Subscription subscription = new Subscription();
        subscription.setStartDate(LocalDate.now());
        subscription.setTypeSub(TypeSubscription.ANNUAL); // Default
        subscription.setPrice(calculateSubscriptionPrice(subscription.getTypeSub()));
        subscription.setEndDate(calculateEndDate(subscription.getTypeSub()));
        subscription = subscriptionRepository.save(subscription);

        // Assign subscription to skier and save
        skier.setSubscription(subscription);
        skier = skierRepository.save(skier);

        // Create registration and assign to course
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Registration registration = new Registration();
        registration.setNumWeek(LocalDate.now().get(WeekFields.ISO.weekOfYear()));
        registration.setSkier(skier);
        registration.setCourse(course);
        registrationRepository.save(registration);

        return skier;
    }
}

