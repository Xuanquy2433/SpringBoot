package com.example.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("")
public class CartController {
    @GetMapping("cart")
    public String cart(Model model) {
        return "cart";
    }

    @GetMapping("checkout")
    public String checkout(Model model) {
        return "checkout";
    }
}
