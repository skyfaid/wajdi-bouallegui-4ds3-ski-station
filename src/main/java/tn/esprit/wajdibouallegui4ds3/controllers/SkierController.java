package tn.esprit.wajdibouallegui4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wajdibouallegui4ds3.entities.Skier;
import tn.esprit.wajdibouallegui4ds3.services.ISkierService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("skier")
public class SkierController {
    private ISkierService skierServices;

    @GetMapping("all")
    public List<Skier> retrieveAll(){
        return skierServices.retrieveAll();
    }
    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("update")
    public Skier updateSkier(@RequestBody Skier skier){
        return skierServices.updateSkier(skier);
    }
    @GetMapping("get/{numSkier}")
    public Skier retrieveSkier(@PathVariable Long numSkier){
        return skierServices.retrieveSkier(numSkier);
    }
    @DeleteMapping("delete/{numSkier}")
    public void removeSkier(@PathVariable Long numSkier){
        skierServices.removeSkier(numSkier);
    }
}

