package com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
