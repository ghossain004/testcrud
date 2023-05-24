package com.simec.testcrud.repositories;

import com.simec.testcrud.models.NewIssue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewIssueRepository extends JpaRepository<NewIssue, Long> {
    List<NewIssue> findIssueById(Pageable pageable, Long id);
}
