package com.springboot.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakeupExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long makeupId;

    @ManyToOne
    @JoinColumn(name = "student_id") // Ensure correct mapping
    private Student student;

    @ManyToOne
    @JoinColumn(name = "original_exam_id") // Ensure correct mapping
    private Exam originalExam;

    private LocalDate makeupDate;
    private String status; // Scheduled, Completed
    private Integer marks; // Nullable until completed
}
