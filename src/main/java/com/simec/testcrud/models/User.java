package com.simec.testcrud.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "useq", initialValue = 101, allocationSize = 1)
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "useq")
    private Long id;
    private String name;
    @Column(unique = true)
    private String userName;
    private String mobile;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdOn = LocalDateTime.now();
    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedOn = LocalDateTime.now();

}
