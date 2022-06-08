package com.example.asm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.asm.domain.Account;
import com.example.asm.dto.AccountLoginDto;
import com.example.asm.service.AccountService;

@Controller
@RequestMapping("")
public class AuthAdminController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpSession session;

    @GetMapping("login")
    public String login(Model model) {
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        model.addAttribute("account", accountLoginDto);
        return "login";
    }

    @GetMapping("logout")
    public String logout(Model model) {
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        if (session.getAttribute("username") != null) {
            session.removeAttribute("username");
            session.removeAttribute("role");
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @PostMapping("login")
    public String loginPost(Model model, @Valid @ModelAttribute("account") AccountLoginDto dto, BindingResult result) {
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        if (result.hasErrors()) {
            return "login";
        }
        Account check = accountService.checkLogin(dto.getUsername(), dto.getPassword());
        if (check != null) {
            String role = "";

            if (check.isAdmin()) {
                role = "admin";
                System.err.println("adminnnnn " + check);
                System.out.println(check.getFullName());
                session.setAttribute("username", check.getUsername());
                session.setAttribute("showName", check.getFullName());
                session.setAttribute("role", role);
                return "redirect:/dashboard/home";
            } else {
                role = "user";
                session.setAttribute("username", check.getUsername());
                session.setAttribute("role", role);
                return "redirect:/shop";
            }

            // session.setAttribute("username", check.getUsername());
            // session.setAttribute("role", role);
            // if(session.getAttribute("request-url") !=null) {
            // return "redirect:"+session.getAttribute("request-url");
            // }
            // return "redirect:/dashboard/home";

        }
        return "redirect:/login";
    }

}
