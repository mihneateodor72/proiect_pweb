package com.example.proiectpweb.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.proiectpweb.model.Employee;

public interface Service<T> {
	List<T> getAllEmployees();
	void saveEmployee(T employee);
	T getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<T> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
