package com.companyEmployeeApp.kalidCompanyEmployeeApp;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.CompanyRepository;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KalidCompanyEmployeeAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KalidCompanyEmployeeAppApplication.class, args);
	}

	@Autowired
private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public void run(String... args) throws Exception {

		Company company=new Company();
		company.setCompanyName("Apple");
		company.setCompanyEmail("apple@gshg");
		company.setCompanyType("Commercial");


		Company company1=new Company();
		company1.setCompanyName("MCC Hospital");
		company1.setCompanyEmail("mcchg@bhg");
		company1.setCompanyType("Non-Profitable");
         companyRepository.save(company);
		 companyRepository.save(company1);
		Employee employee1=new Employee("kalid","Tahir","IT",
				32,"kalggf@ggvhg","SilverSpring,MD",company);
		Employee employee2=new Employee("biniam","tt","GP doctor",
				35,"binjff@ggjhg","Sterling,VA",company1);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

	}
}
