package tn.esprit.wajdibouallegui4ds3.services;

import tn.esprit.wajdibouallegui4ds3.entities.Instructor;

import java.util.List;

public interface IInstructorService {
    Instructor addInstructor (Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
    void removeInstructor(Long numInstructor);
    List<Instructor> retrieveAll ();
}
