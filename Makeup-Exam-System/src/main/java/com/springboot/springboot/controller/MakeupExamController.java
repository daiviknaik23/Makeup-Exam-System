package com.springboot.springboot.controller;

import com.springboot.springboot.entity.MakeupExam;
import com.springboot.springboot.repository.MakeupExamRepository;
import com.springboot.springboot.service.MakeupExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/makeup_exams")
@CrossOrigin(origins = "*")
public class MakeupExamController {

    @Autowired
    private MakeupExamRepository makeupExamRepo;

    @Autowired
    private MakeupExamService makeupExamService;

    // Create a new Makeup Exam
    @PostMapping
    public ResponseEntity<MakeupExam> createMakeupExam(@RequestBody MakeupExam makeupExam) {
        MakeupExam savedExam = makeupExamRepo.save(makeupExam);
        return ResponseEntity.ok(savedExam);
    }

    // Retrieve all Makeup Exams
    @GetMapping("/all")
    public List<MakeupExam> getAllMakeupExams() {
        return makeupExamRepo.findAll();
    }

    // Retrieve Makeup Exam by ID
    @GetMapping("/{id}")
    public ResponseEntity<MakeupExam> getMakeupExamById(@PathVariable Long id) {
        Optional<MakeupExam> exam = makeupExamRepo.findById(id);
        return exam.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing Makeup Exam
    @PutMapping("/update/{id}")
    public ResponseEntity<MakeupExam> updateMakeupExam(@PathVariable Long id, @RequestBody MakeupExam updatedExam) {
        Optional<MakeupExam> existingExam = makeupExamRepo.findById(id);
        if (existingExam.isPresent()) {
            MakeupExam makeupExam = existingExam.get();
            makeupExam.setMakeupDate(updatedExam.getMakeupDate());
            makeupExam.setStatus(updatedExam.getStatus());
            makeupExam.setMarks(updatedExam.getMarks());

            MakeupExam savedExam = makeupExamRepo.save(makeupExam);
            return ResponseEntity.ok(savedExam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Makeup Exam by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMakeupExam(@PathVariable Long id) {
        if (makeupExamRepo.existsById(id)) {
            makeupExamRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Delete Makeup Exams based on original exam ID
    @DeleteMapping("/original_exam/{examId}")
    public ResponseEntity<Void> deleteByOriginalExam(@PathVariable Long examId) {
        makeupExamService.deleteMakeupsByOriginalExamId(examId);  // Delegating to service
        return ResponseEntity.noContent().build();
    }

    // ✅ **New Endpoint: Mark a Makeup Exam as Complete**
    @PatchMapping("/{id}/complete")
    public ResponseEntity<MakeupExam> completeMakeupExam(@PathVariable Long id) {
        Optional<MakeupExam> existingExam = makeupExamRepo.findById(id);
        
        if (existingExam.isPresent()) {
            MakeupExam makeupExam = existingExam.get();
            makeupExam.setStatus("COMPLETED"); // Assuming there's a status field
            MakeupExam savedExam = makeupExamRepo.save(makeupExam);
            return ResponseEntity.ok(savedExam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
