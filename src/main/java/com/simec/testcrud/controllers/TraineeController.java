package com.simec.testcrud.controllers;

import com.simec.testcrud.models.Trainee;
import com.simec.testcrud.repositories.TraineeRepository;
import com.simec.testcrud.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trainee")
@CrossOrigin(origins = "*")

public class TraineeController {

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/getAll")
    private List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @PostMapping("/create")
    private void saveTrainee(@RequestBody Trainee trainee){
        traineeService.save(trainee);
    }

    @GetMapping("/get/{id}")
    Trainee getTrainee(@PathVariable("id") Long id){
        Optional<Trainee> trainee = traineeRepository.findById(id);
        return trainee.get();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteTrainee(@PathVariable("id") Long id){
        traineeService.delete(id);
    }

    @PutMapping("/update/{id}")
    private void updateTrainee(@RequestBody Trainee trainee)
    {
        traineeService.update(trainee);
    }
}
