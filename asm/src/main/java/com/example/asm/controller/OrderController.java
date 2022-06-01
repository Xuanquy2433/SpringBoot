package com.example.asm.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.asm.domain.Account;
import com.example.asm.domain.Orders;
import com.example.asm.dto.OrderDto;
import com.example.asm.service.AccountService;
import com.example.asm.service.OrderService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("dashboard")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @GetMapping("orders")
    public String categories(Model model) {

        List<Orders> order = orderService.findAll();
        model.addAttribute("orders", order);

        return "admin/custom/orders";
    }

    @GetMapping("orders/create")
    public String createCategories(Model model) {
        System.out.println("go here create");

        Orders orders = new Orders();
        model.addAttribute("orders", orders);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("listAccounts", accounts);
        return "admin/form/createOrders";

    }

    // create order
    @PostMapping("orders/create")
    public String createCategoriesPost(Model model, @Valid @ModelAttribute("orders") OrderDto dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
                
        if (result.hasErrors()) {
            // List<Account> accounts = accountService.findAll();
            // model.addAttribute("listAccounts", accounts);
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR");
            return "admin/form/createOrders";
        }

        Orders copy = new Orders();
        
        BeanUtils.copyProperties(dto, copy);
        System.out.println("copy: " + copy);
        orderService.save(copy);
        redirectAttributes.addFlashAttribute("success", "Add succsess");
        return "redirect:/dashboard/orders";

    }

}
