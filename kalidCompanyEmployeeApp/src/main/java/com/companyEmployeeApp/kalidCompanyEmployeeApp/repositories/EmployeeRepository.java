package com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
