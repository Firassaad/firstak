package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Site;
public interface SiteRepository extends JpaRepository<Site, Long> {
@Query("select c from Site c where c.id=:id")

public Site affliste(@Param("id") Long id);
}
