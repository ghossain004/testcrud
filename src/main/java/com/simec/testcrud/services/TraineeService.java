package com.simec.testcrud.services;

import com.simec.testcrud.models.Trainee;
import com.simec.testcrud.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    public List<Trainee> getAllTrainees (){
        List<Trainee> trainees = traineeRepository.findAll();
        return trainees;
    }

    public void save(Trainee trainee){
        traineeRepository.save(trainee);
    }

    public void delete (Long id){
        traineeRepository.deleteById(id);
    }

    public void update (Trainee trainee){
        traineeRepository.save(trainee);
    }

    public Long findTraineeById (Long id){
        traineeRepository.findById(id);
        return id;
    }

    public void deleteById (Long id){
        traineeRepository.deleteById(id);
    }

}
