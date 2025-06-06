package com.springboot.springboot.repository;

import com.springboot.springboot.entity.MakeupExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MakeupExamRepository extends JpaRepository<MakeupExam, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM MakeupExam m WHERE m.originalExam.examId = :examId")
    void deleteByOriginalExamId(@Param("examId") Long examId);
}
