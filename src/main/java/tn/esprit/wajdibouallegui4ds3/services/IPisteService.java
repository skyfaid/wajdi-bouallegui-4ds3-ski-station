package tn.esprit.wajdibouallegui4ds3.services;

import tn.esprit.wajdibouallegui4ds3.entities.Color;
import tn.esprit.wajdibouallegui4ds3.entities.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste (Piste piste);
    Piste updatePiste (Piste piste);
    Piste retrievePiste (Long numPiste);
    void removePiste(Long numPiste);
    List<Piste> retrieveAll ();
    List<Piste> retrieveAllByColor (Color color);
    Piste assignPisteToSkier (Long numPiste , Long numSkier);
}
