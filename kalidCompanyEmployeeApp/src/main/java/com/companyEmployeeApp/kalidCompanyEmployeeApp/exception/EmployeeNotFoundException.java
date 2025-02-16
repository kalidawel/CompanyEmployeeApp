package com.companyEmployeeApp.kalidCompanyEmployeeApp.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
