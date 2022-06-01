package com.example.asm.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AccountDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String photo;
    private boolean activated;
    private boolean admin;

}
