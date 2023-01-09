package com.greatLearning.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.emp.model.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long>{

}
