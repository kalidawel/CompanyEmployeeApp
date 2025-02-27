package com.companyEmployeeApp.kalidCompanyEmployeeApp.controllers;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.AuthorizationRequest;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.PostNewUser;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.UserDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.services.UserCredentialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserCredentialService userCredentialService;

    public UserController(UserCredentialService userCredentialService) {
        this.userCredentialService = userCredentialService;
    }
    @PostMapping("/")
    public ResponseEntity<UserDto> postNewUser(@RequestBody PostNewUser postNewUser) {

        return new ResponseEntity<>(userCredentialService.createUser(postNewUser)
                , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthorizationRequest request) {
        return new ResponseEntity<>(userCredentialService.login(request), HttpStatus.OK);
    }
}
