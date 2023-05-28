package com.example.sync_intern_bug_tracker.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bugs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bug {
    @Id
    @SequenceGenerator(name = "BugId",sequenceName = "BugId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BugId")
    private Long id;
    @Column(length = 255)
    private String title;

    @Column(length = 2000)
    private String description;
@Column(length = 255)
    private String status;

    @Column(length = 255)
    private String priority;
}


