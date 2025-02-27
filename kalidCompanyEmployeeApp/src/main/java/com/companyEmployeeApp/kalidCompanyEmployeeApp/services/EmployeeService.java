package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.EmployeeDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(EmployeeDto employeeDto, Long id);
    public void deleteEmployee(Long id);


}
