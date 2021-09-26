package com.example.listingapp.dto;

import com.example.listingapp.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveDto {

    private String name;
    private String surname;
    private String email;

    private String password;
    private UserType userType;
}
