package com.springboot.springboot.controller;

import com.springboot.springboot.entity.Exam;
import com.springboot.springboot.repository.ExamRepository;
import com.springboot.springboot.repository.MakeupExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "*")
public class ExamController {

    @Autowired
    private ExamRepository examRepo;

    @Autowired
    private MakeupExamRepository makeupExamRepo;

    // Create a new exam
    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepo.save(exam);
    }

    // Get all exams
    @GetMapping
    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    // Get exam by ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam not found with id = " + id));
    }

    // Update exam by ID
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        updatedExam.setExamId(id);
        return examRepo.save(updatedExam);
    }

    // Delete exam by ID
    @DeleteMapping("/{id}")
@Transactional
public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
    if (!examRepo.existsById(id)) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam not found with id = " + id);
    }

    makeupExamRepo.deleteByOriginalExamId(id);  // ✅ Correct custom method

    examRepo.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
