package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.AuthorizationRequest;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.PostNewUser;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.dto.UserDto;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.UserCredential;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.exception.InvalidRoleException;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.exception.UsernameTakenException;
import com.companyEmployeeApp.kalidCompanyEmployeeApp.repositories.UserCredentialRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialServiceImpl implements UserCredentialService{


    private UserCredentialRepository userCredentialRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;


    public UserCredentialServiceImpl(
            UserCredentialRepository userCredentialRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.userCredentialRepository = userCredentialRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserDto createUser(PostNewUser postNewUser) {
        // Check if username is already taken
        Optional<UserCredential> possibleNameTaken =
                userCredentialRepository
                        .findByUsername(postNewUser
                                .username()
                                .toLowerCase());
        if(possibleNameTaken.isPresent()){
            throw new UsernameTakenException("Username has been taken, Please choose another!");
        }

        // Prevent creation of ADMIN users
        if(postNewUser.role().equals("ADMIN")) {
            throw new InvalidRoleException("User cannot be created as ADMIN, has to be USER or DEALER");
        }

        // Create and save new user
        UserCredential userCredential = new UserCredential(
                postNewUser.username().toLowerCase(),
                passwordEncoder.encode(postNewUser.password()),
                postNewUser.role().toUpperCase()
        );
        userCredential = userCredentialRepository.save(userCredential);

        // Convert to DTO for return
        UserDto userDto = new UserDto(userCredential.getUsername(), userCredential.getRole());

        return userDto;
    }

    @Override
    public String login(AuthorizationRequest request) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                request.username(),
//                request.password()
//        ));
//        String jwt = jwtService.generateToken(request.username());
//        return jwt;
        return "";
    }
}
