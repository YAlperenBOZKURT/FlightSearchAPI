package com.alperenbozkurt.FlightRestAPI.service.concrete;

import com.alperenbozkurt.FlightRestAPI.dto.UserDto;
import com.alperenbozkurt.FlightRestAPI.dto.UserRequest;
import com.alperenbozkurt.FlightRestAPI.dto.UserResponse;
import com.alperenbozkurt.FlightRestAPI.entities.User;
import com.alperenbozkurt.FlightRestAPI.enums.Role;
import com.alperenbozkurt.FlightRestAPI.repository.UserRepository;
import com.alperenbozkurt.FlightRestAPI.service.abstracts.IAuthenticationService;
import com.alperenbozkurt.FlightRestAPI.service.abstracts.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final UserRepository userRepository;

    private final IJwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final MongoTemplate mongoTemplate;

    @Override
    public UserResponse save(UserDto userDto) {
        User newUser = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nameSurname(userDto.getNameSurname())
                .role(Role.USER)
                .build();
        userRepository.save(newUser);
        var token = jwtService.generateToken(newUser);
        return UserResponse.builder().token(token).build();
    }

    @Override
    public UserResponse auth(UserRequest userRequest) {
        Query query = new Query(Criteria.where("username").is(userRequest.getUsername()));
        User user = mongoTemplate.findOne(query, User.class);
        if (user == null) {
            return null;
        }

      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), userRequest.getPassword()));
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }


}
