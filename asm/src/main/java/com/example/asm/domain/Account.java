package com.example.asm.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 200, nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
}
