package com.example.asm.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String image;
    @NotEmpty
    // @Range(min = 0, max = 10)
    private String price;

    private Date createDate;

    private boolean available;

    @NotEmpty
    private String description;

    private int categoryId;

}
