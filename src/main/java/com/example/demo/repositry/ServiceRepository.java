package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

}
