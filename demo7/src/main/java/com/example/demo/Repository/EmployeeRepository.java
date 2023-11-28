package com.example.demo.Repository;

import com.example.demo.Models.Book;
import com.example.demo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
