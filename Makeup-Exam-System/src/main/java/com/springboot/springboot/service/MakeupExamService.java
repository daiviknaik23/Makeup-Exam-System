package com.springboot.springboot.service;

import com.springboot.springboot.repository.MakeupExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MakeupExamService {

    @Autowired
    private MakeupExamRepository makeupExamRepository;

    @Transactional
    public void deleteMakeupsByOriginalExamId(Long examId) {
        makeupExamRepository.deleteByOriginalExamId(examId);
    }
}
