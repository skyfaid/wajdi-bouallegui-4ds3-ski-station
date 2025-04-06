package tn.esprit.wajdibouallegui4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wajdibouallegui4ds3.entities.Instructor;
import tn.esprit.wajdibouallegui4ds3.services.IInstructorService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("instructor")
public class InstructorController {
    private IInstructorService instructorServices;

    @GetMapping("all")
    public List<Instructor> retrieveAll(){
        return instructorServices.retrieveAll();
    }
    @PostMapping("add")
    public Instructor addPiste(@RequestBody Instructor instructor){
        return instructorServices.addInstructor(instructor);
    }
    @PutMapping("update")
    public Instructor updatePiste(@RequestBody Instructor instructor){
        return instructorServices.updateInstructor(instructor);
    }
    @GetMapping("get/{numInstructor}")
    public Instructor retrievePiste(@PathVariable Long numInstructor){
        return instructorServices.retrieveInstructor(numInstructor);
    }
    @DeleteMapping("delete/{numInstructor}")
    public void removePiste(@PathVariable Long numInstructor){
        instructorServices.removeInstructor(numInstructor);
    }

    @PostMapping("/addAndAssign/{numCourse}")
    public Instructor addInstructorAndAssignToCourse(
            @RequestBody Instructor instructor,
            @PathVariable Long numCourse) {
        return instructorServices.addInstructorAndAssignToCourse(instructor, numCourse);
    }


}
