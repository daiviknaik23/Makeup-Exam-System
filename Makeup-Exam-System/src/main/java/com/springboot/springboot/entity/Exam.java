package com.springboot.springboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    private String subject;
    private LocalDate examDate;
    private String reason;

    // Default constructor
    public Exam() {}

    // Parameterized constructor
    public Exam(Long examId, String subject, LocalDate examDate, String reason) {
        this.examId = examId;
        this.subject = subject;
        this.examDate = examDate;
        this.reason = reason;
    }

    // Getters and Setters
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
