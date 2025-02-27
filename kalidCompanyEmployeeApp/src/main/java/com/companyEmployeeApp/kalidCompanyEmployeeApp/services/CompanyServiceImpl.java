package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.CompanyDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.exception.CompanyNotFoundException;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService  {

@Autowired
private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
       Optional<Company> optionalCompany= companyRepository.findById(id);
    if(optionalCompany.isEmpty()){
        throw new CompanyNotFoundException("Company with the id: "+id+"not exist");
    }

     return optionalCompany.get();
    }

    @Override
    public Company createCompany(Company company) {
         if (company == null) {
            throw new CompanyNotFoundException("Company cannot be null");
        }

        if (company.getCompanyName() == null || company.getCompanyName().isEmpty()) {
            throw new CompanyNotFoundException("Company name cannot be empty");
        }
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(CompanyDto companyDto, long id) {

        Optional<Company> optionalCompany= companyRepository.findById(id);
        if (optionalCompany.isEmpty()){

            throw new CompanyNotFoundException("the company you are looking is not exist");
        }

        Company toBeUpdatedCompany=optionalCompany.get();
        toBeUpdatedCompany.setCompanyName(companyDto.getCompanyName());
        toBeUpdatedCompany.setCompanyEmail(companyDto.getCompanyEmail());
        toBeUpdatedCompany.setCompanyType(companyDto.getCompanyType());
       Company updatedCompany= companyRepository.save(toBeUpdatedCompany);
       return updatedCompany;
    }

    @Override
    public void deleteCompany(long id) {

        Company company=getCompanyById(id);
        companyRepository.delete(company);
    }
}
