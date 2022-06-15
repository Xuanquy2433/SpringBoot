package com.example.asm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.asm.domain.OrderDetail;
import com.example.asm.domain.OrderDetailKey;

public interface OrderDetailRes extends JpaRepository<OrderDetail, OrderDetailKey>{
    
}
