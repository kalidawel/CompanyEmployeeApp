package com.companyEmployeeApp.kalidCompanyEmployeeApp.controllers;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.EmployeeDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
private EmployeeService employeeService;

    @GetMapping("/home")
    public String home(HttpServletRequest request){
        return "Well Come To Company_Employee api" +request.getSession().getId();
    }


    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees=employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
     @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
            Employee employee=employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
            return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);

        }


        @PutMapping("/update/{id}")
        public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable long id) {
            return new ResponseEntity<>(employeeService.updateEmployee(employeeDto,id), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
            public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
                employeeService.deleteEmployee(id);
                return new ResponseEntity<>("Employee deleted with ID " + id, HttpStatus.OK);
            }

}
