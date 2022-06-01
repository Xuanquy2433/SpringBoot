package com.example.asm.Repository;

import com.example.asm.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, String>{
    
}
