package com.simec.testcrud.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "nseq", initialValue = 101, allocationSize = 1)
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nseq")
    private Long id;
    private String tracker;
    private String subject;
    private String description;
    private String status;
    private String priority;
    private String assignee;
    private String parentTask;
    private LocalDate startDate;
    private LocalDate dueDate;
    private int estimatedTime;
    private int donePercentage;

}
