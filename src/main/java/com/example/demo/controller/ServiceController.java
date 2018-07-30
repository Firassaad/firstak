package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Service;
import com.example.demo.repository.ServiceRepository;

@RestController
@RequestMapping("/service")
@CrossOrigin("*")
public class ServiceController {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	
	@PostMapping("/save")
	public Service add(@RequestBody Service service) {
		return serviceRepository.save(service);
	}

	@GetMapping("/getAllService")
	public List<Service> getAllService() {
		return serviceRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(Service u) {
		serviceRepository.delete(u);

	}


}
