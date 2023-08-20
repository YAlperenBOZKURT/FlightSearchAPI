package com.alperenbozkurt.FlightRestAPI.service.abstracts;

import com.alperenbozkurt.FlightRestAPI.dto.UserDto;
import com.alperenbozkurt.FlightRestAPI.dto.UserRequest;
import com.alperenbozkurt.FlightRestAPI.dto.UserResponse;

public interface IAuthenticationService {

    UserResponse save(UserDto userDto);

    UserResponse auth(UserRequest userRequest);



}
