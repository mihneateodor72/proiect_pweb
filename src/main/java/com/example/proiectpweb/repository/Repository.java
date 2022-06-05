package com.example.proiectpweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proiectpweb.model.Employee;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long>{

}
