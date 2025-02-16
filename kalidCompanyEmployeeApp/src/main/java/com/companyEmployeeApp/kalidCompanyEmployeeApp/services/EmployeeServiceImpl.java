package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;


import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.exception.EmployeeNotFoundException;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
               Optional<Employee> optionalEmployee= employeeRepository.findById(id);
                return employeeRepository.findById(id).orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with id of "
                                + id +" is not found"));

    }

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundException("the employee with the id: "+id+" Not exist");
        }
        Employee toBeUpdatedEmployee=optionalEmployee.get();
        toBeUpdatedEmployee.setfName(employee.getfName());
        toBeUpdatedEmployee.setlName(employee.getlName());
        toBeUpdatedEmployee.setEmpDepartment(employee.getEmpDepartment());
        toBeUpdatedEmployee.setAge(employee.getAge());
        toBeUpdatedEmployee.setEmail(employee.getEmail());
        toBeUpdatedEmployee.setAddress(employee.getAddress());
        toBeUpdatedEmployee.setCompany(employee.getCompany());

        return employeeRepository.save(toBeUpdatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee with id :" +id+" not found");

        }else {
            employeeRepository.deleteById(id);}
    }
}
