package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agent;
import com.example.demo.Entities.Question;
import com.example.demo.repository.QuestionRepository;

@CrossOrigin("*")
@RestController
public class QuestionController {
@Autowired
QuestionRepository qr;


@PostMapping("/question/save")
public Question add(@RequestBody Question q) {
	return qr.save(q);
}
}
