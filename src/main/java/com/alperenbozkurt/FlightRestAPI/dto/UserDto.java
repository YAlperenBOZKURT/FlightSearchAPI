package com.alperenbozkurt.FlightRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
public class UserDto {

    private String nameSurname;
    private String username;
    private String password;
}
