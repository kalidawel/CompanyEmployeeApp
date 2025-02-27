package com.companyEmployeeApp.kalidCompanyEmployeeApp.controllers;


import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.CompanyDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @GetMapping("/home")
    public String home(){
        return "Well Come To Company_Employee api";
    }


    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompany(){
      List<Company> companies=companyService.getAllCompany();
      return new ResponseEntity<>(companies, HttpStatus.OK);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){
        Company company=companyService.getCompanyById(id);
        return new ResponseEntity<>(company,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.createCompany(company),HttpStatus.CREATED);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable long id) {
        log.info(companyDto.toString());
        return new ResponseEntity<>(companyService.updateCompany(companyDto,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteCompany(@PathVariable long id) {
            companyService.deleteCompany(id);
            return new ResponseEntity<>("Company deleted with ID " + id, HttpStatus.OK);
        }
}
