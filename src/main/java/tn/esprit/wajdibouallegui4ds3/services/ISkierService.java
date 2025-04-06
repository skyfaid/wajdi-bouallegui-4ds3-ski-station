package tn.esprit.wajdibouallegui4ds3.services;

import tn.esprit.wajdibouallegui4ds3.entities.Skier;

import java.util.List;

public interface ISkierService {
    Skier addSkier (Skier skier);
    Skier updateSkier (Skier skier);
    Skier retrieveSkier (Long numSkier);
    void removeSkier(Long numSkier);
    List<Skier> retrieveAll ();
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
}
