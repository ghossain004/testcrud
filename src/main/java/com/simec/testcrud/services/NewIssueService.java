package com.simec.testcrud.services;

import com.simec.testcrud.models.NewIssue;
import com.simec.testcrud.repositories.NewIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewIssueService {

    @Autowired
    private NewIssueRepository newIssueRepository;

    public List<NewIssue> getAllIssues(){
        List<NewIssue> newIssues = newIssueRepository.findAll();
        return newIssues;
    }

    public void save (NewIssue newIssue){
        newIssueRepository.save(newIssue);
    }

    public void delete(Long id){
        newIssueRepository.deleteById(id);
    }

    public void update(NewIssue newIssue){
        newIssueRepository.save(newIssue);
    }

    public Long findIssueById(Long id){
        newIssueRepository.findById(id);
        return id;
    }

    public void deleteById(Long id){
        newIssueRepository.deleteById(id);
    }

    public List<NewIssue> getAllIssues(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<NewIssue> pageResult = newIssueRepository.findAll(paging);
        if (pageResult.hasContent()){
            return pageResult.getContent();
        }else {
            return new ArrayList<NewIssue>();
        }
    }
}
