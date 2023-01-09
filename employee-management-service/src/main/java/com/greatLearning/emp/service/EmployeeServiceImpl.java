package com.greatLearning.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.emp.dao.EmployeeJpaRepository;
import com.greatLearning.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeJpaRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeJpaRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		//imperative style of coding
		/*
		 * Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
		 * if(optionalEmployee.isPresent()) { return optionalEmployee.get(); } throw new
		 * IllegalArgumentException("invalid employee id");
		 */
		return this.employeeRepository
						.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("invalid employee id passed"));
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);

	}

}
