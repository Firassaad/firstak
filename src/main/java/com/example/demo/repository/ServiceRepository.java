package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
