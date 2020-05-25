package com.kubicodes.springboot.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kubicodes.springboot.web.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{

}
