package com.example.asm.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String image;
    @NotEmpty
    // @Range(min = 0, max = 10)
    private String price;
    @NotEmpty
    private String description;
    private int categoryId;

}
