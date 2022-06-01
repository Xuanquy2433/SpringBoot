package com.example.asm.Repository;

import com.example.asm.domain.Categories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository <Categories, Integer> {
    
}
