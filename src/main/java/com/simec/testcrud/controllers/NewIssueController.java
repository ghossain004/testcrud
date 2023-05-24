package com.simec.testcrud.controllers;

import com.simec.testcrud.models.NewIssue;
import com.simec.testcrud.repositories.NewIssueRepository;
import com.simec.testcrud.services.NewIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issue")
@CrossOrigin(origins = "*")
public class NewIssueController {

    @Autowired
    private NewIssueService newIssueService;

    @Autowired
    private NewIssueRepository newIssueRepository;

//    @GetMapping("/getAll")
//    private List<NewIssue> getAllIssues(){
//        return newIssueService.getAllIssues();
//    }

    @GetMapping("/get/{id}")
    NewIssue getTrainee(@PathVariable("id") Long id){
        Optional<NewIssue> newIssue = newIssueRepository.findById(id);
        return newIssue.get();
    }

    @PostMapping("/create")
    private void newIssueCreate(@RequestBody NewIssue newIssue){
        newIssueService.save(newIssue);
    }

    @PutMapping("/update/{id}")
    private void updateIssue(@RequestBody NewIssue newIssue){
        newIssueService.update(newIssue);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteIssue(@PathVariable Long id){
        newIssueService.deleteById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NewIssue>> getAllIssues(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        List<NewIssue> list = newIssueService.getAllIssues(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<NewIssue>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
