package tn.esprit.wajdibouallegui4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.wajdibouallegui4ds3.entities.Skier;
import tn.esprit.wajdibouallegui4ds3.repositories.ISkierRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SkierServiceImpl implements ISkierService {

    private ISkierRepository skierRepository;

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
}

