package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.AuthorizationRequest;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.PostNewUser;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.UserDto;

public interface UserCredentialService {
    //since it's a demo application , we just have two method
    UserDto createUser(PostNewUser postNewUser);
    String login(AuthorizationRequest request);

}
