package com.example.asm.Repository;

import com.example.asm.domain.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository  extends JpaRepository <Orders, Integer>{
    
}
