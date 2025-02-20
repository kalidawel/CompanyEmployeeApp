package com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends ListCrudRepository<UserCredential,String> {
    Optional<UserCredential> findByUsername(String username);
}
