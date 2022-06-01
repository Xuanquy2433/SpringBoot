package com.example.asm.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderDto {
    private int id;
    private String username;
    private String createDate;
    @NotEmpty
    private String address;

}
