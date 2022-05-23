package com.example.asm.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.asm.domain.Account;

import com.example.asm.domain.Role;
import com.example.asm.dto.AccountDto;
import com.example.asm.service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("accounts")
    public String categories(Model model) {
        System.out.println("go here");

        List<Account> accounts = accountService.findAll();
        // System.out.println("List account: "+accounts);
        model.addAttribute("accounts", accounts);
        return "admin/custom/accounts";
    }

    @GetMapping("accounts/create")
    public String createCategories(Model model) {
        System.out.println("go here create");

        Account account = new Account();
        model.addAttribute("accounts", account);
        return "admin/form/createAccounts";

    }

    // create accounts
    @PostMapping("accounts/create")
    public String createCategoriesPost(Model model, @Valid @ModelAttribute("accounts") AccountDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR");
            return "admin/form/createAccounts";
        }
        Role role = new Role();

        role.setRoleId(dto.getRole());
        Account copy = new Account();
        copy.setRole(role);
        BeanUtils.copyProperties(dto, copy);
        System.out.println("copy: " + copy);
        accountService.save(copy);
        return "redirect:/dashboard/accounts";

    }
}
