package com.example.asm.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.asm.domain.Products;
import com.example.asm.dto.CartDto;
import com.example.asm.dto.ItemDto;
import com.example.asm.service.ProductService;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String cart(Model model) {
        return "cart";
    }

    @Autowired
    HttpSession httpSession;

    @GetMapping("addCart/{id}")
    public String add(Model model,
            @PathVariable("id") int productId,
            RedirectAttributes redirAttrs) {
        if (productId != 0) {
            /**
             * step 1: lấy detail product
             * step 2: kiểm tra xem cart session có tồn tại chưa
             * + chưa thì tạo mới
             * step 3: tao itemDTO và add vào cart
             * step 4: reset cart -> cart list
             */
            CartDto carts = (CartDto) httpSession.getAttribute("cart");
            Optional<Products> detail = productService.findById(productId);
            ItemDto item = new ItemDto();
            if (detail != null) {
                item.setMaSp(detail.get().getId());
                item.setSoLuong(1);
                item.setPrice(detail.get().getPrice());
                item.setTitle(detail.get().getName());
                item.setImage(detail.get().getImage());
                if (carts != null) {
                    // có cart
                    carts.add(item);
                    redirAttrs.addFlashAttribute("success", "đã cập nhật vào giỏ hàng");
                } else {
                    carts = new CartDto();
                    carts.add(item);
                    // tạo mới cart
                    redirAttrs.addFlashAttribute("success", "đã thêm vào giỏ hàng");
                }
                httpSession.setAttribute("cart", carts);

            }

        }
        return "redirect:/cart";
    }

    @GetMapping("removeCart/{productId}")
    public String remove(Model model,
            @PathVariable("productId") int productId,
            RedirectAttributes redirAttrs) {
        if (productId != 0) {
            /**
             * step 1: lấy detail product
             * step 2: kiểm tra xem cart session có tồn tại chưa
             * + chưa thì tạo mới
             * step 3: tao itemDTO và add vào cart
             * step 4: reset cart -> cart list
             */
            CartDto carts = (CartDto) httpSession.getAttribute("cart");
            Optional<Products> detail = productService.findById(productId);
            ItemDto item = new ItemDto();
            if (detail != null) {
                item.setMaSp(detail.get().getId());
                item.setSoLuong(1);
                item.setPrice(detail.get().getPrice());
                item.setTitle(detail.get().getName());
                item.setImage(detail.get().getImage());
                if (carts != null) {
                    // có cart
                    carts.remove(item);
                }
                httpSession.setAttribute("cart", carts);
                redirAttrs.addFlashAttribute("success", "đã xóa vào giỏ hàng");
            }

        }
        return "redirect:/cart";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable("id") int id,
            RedirectAttributes redirAttrsAttributes) {
        if (id != 0) {
            CartDto carts = (CartDto) httpSession.getAttribute("cart");
            Optional<Products> detail = productService.findById(id);
            ItemDto item = new ItemDto();
            if (detail != null) {
                item.setMaSp(detail.get().getId());
                item.setTitle(detail.get().getName());
                item.setSoLuong(1);
                item.setPrice(detail.get().getPrice());
                item.setImage(detail.get().getImage());
                if (carts != null) {
                    carts.dete(item);
                }
                httpSession.setAttribute("cart", carts);
                redirAttrsAttributes.addFlashAttribute("success", "đã giảm số lượng sản phẩm");
            }
        }
        return "redirect:/cart";
    }
}
