package com.example.proiectpweb.service;

import com.example.proiectpweb.model.Company;
import com.example.proiectpweb.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public List<Company> getAllEmployees() {
        return  repository.findAll();
    }

    @Override
    public void saveEmployee(Company employee) {
        repository.save(employee);
    }

    @Override
    public Company getEmployeeById(long id) {
        Optional<Company> optional = repository.findById(id);
        if(optional.isPresent())
            return optional.get();

        throw new RuntimeException("Company not found, id: " + id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Company> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repository.findAll(pageable);
    }
}
