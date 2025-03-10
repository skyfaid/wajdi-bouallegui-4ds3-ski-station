package tn.esprit.wajdibouallegui4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.wajdibouallegui4ds3.entities.Course;
import tn.esprit.wajdibouallegui4ds3.repositories.ICourseRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl  implements ICourseService {

    private ICourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void removeCourse(Long numCourse) {
        courseRepository.deleteById(numCourse);
    }

    @Override
    public List<Course> retrieveAll() {
        return courseRepository.findAll();
    }
}

