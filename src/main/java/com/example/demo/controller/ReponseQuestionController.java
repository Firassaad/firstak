package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.ReponseQuestion;
import com.example.demo.repository.ReponseQuestionRepository;

@CrossOrigin("*")
@RestController
public class ReponseQuestionController {
	@Autowired
	ReponseQuestionRepository reponseQuestionRepository;

	@PostMapping("/reponseQuestion/save")
	public Boolean add(@RequestBody ReponseQuestion reponseQuestionList[]) {
		for (ReponseQuestion reponseQuestion : reponseQuestionList) {
			System.out.println("key ="+reponseQuestion.getReponse());
			reponseQuestionRepository.save(reponseQuestion);

		}
		return true;
	}
}
