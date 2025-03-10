package tn.esprit.wajdibouallegui4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.wajdibouallegui4ds3.entities.Instructor;
import tn.esprit.wajdibouallegui4ds3.repositories.IInstructorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements IInstructorService{

    private IInstructorRepository instructorRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public List<Instructor> retrieveAll() {
        return instructorRepository.findAll();
    }
}

