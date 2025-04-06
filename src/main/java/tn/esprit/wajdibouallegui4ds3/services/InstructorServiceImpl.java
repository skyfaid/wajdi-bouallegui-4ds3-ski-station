package tn.esprit.wajdibouallegui4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.wajdibouallegui4ds3.entities.Course;
import tn.esprit.wajdibouallegui4ds3.entities.Instructor;
import tn.esprit.wajdibouallegui4ds3.repositories.ICourseRepository;
import tn.esprit.wajdibouallegui4ds3.repositories.IInstructorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements IInstructorService{

    private IInstructorRepository instructorRepository;
    private ICourseRepository courseRepository;

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

    @Override
    @Transactional
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        instructor = instructorRepository.save(instructor);
        course.setInstructor(instructor);
        courseRepository.save(course);

        return instructor;
    }
}

