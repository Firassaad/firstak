package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.GroupeQuestion;
import com.example.demo.Entities.Question;
import com.example.demo.repository.GroupeQuestionRepository;

@CrossOrigin("*")
@RestController
public class GroupeQuestionController {
	@Autowired
	GroupeQuestionRepository groupeQuestionRepository;
	
	@GetMapping("/groupequestion/getListQuestion/{id}")
	public List<Question> getListQuestionByGQId(@PathVariable(value="id") Long groupeQuestion_id){
		List<GroupeQuestion> l = groupeQuestionRepository.findAll();
		List<Question> lq =null;
		for(int i =0 ; i<l.size();i++) {
			if(l.get(i).getId()==groupeQuestion_id)
				lq =l.get(i).getQuestions();
				
		}
		return lq;
	}

}
