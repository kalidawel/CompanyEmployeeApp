package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;


import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.exception.EmployeeNotFoundException;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.CompanyRepository;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
     private CompanyRepository companyRepository;

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

          if (employee == null) {
                    throw new EmployeeNotFoundException("Employee data cannot be null.");
                }
                   //checking the company
                Company company = employee.getCompany();
                if (company != null) {
                    Company companyToBeSet = companyRepository.findById(company.getCompanyId())
                            .orElseGet(() -> {
                                companyRepository.save(company);
                                return company;
                            });

                    employee.setCompany(companyToBeSet);
                }

                return employeeRepository.save(employee);


    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

                if (employee == null) {
                    throw new EmployeeNotFoundException("Employee data cannot be null.");
                }

                Employee toBeUpdatedEmployee = employeeRepository.findById(id)
                        .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID: " + id + " does not exist"));

                Company company = employee.getCompany();
                if (company != null) {
                    Company existingCompany = companyRepository.findById(company.getCompanyId())
                            .orElseGet(() -> {
                                companyRepository.save(company);
                                return company;
                            });

                    toBeUpdatedEmployee.setCompany(existingCompany);
                }


                 toBeUpdatedEmployee.setfName(employee.getfName());
                 toBeUpdatedEmployee.setlName(employee.getlName());
                 toBeUpdatedEmployee.setEmpDepartment(employee.getEmpDepartment());
                 toBeUpdatedEmployee.setAge(employee.getAge());
                 toBeUpdatedEmployee.setEmail(employee.getEmail());
                 toBeUpdatedEmployee.setAddress(employee.getAddress());

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
