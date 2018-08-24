package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
