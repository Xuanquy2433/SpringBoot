package com.example.asm.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.asm.dto.Product;
import com.example.asm.service.ProductService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("products")
    public String products(Model model) {
        List<Product> products = productService.getListProduct();
        model.addAttribute("products", products);
        return "admin/custom/products";
    }

    @GetMapping("products/create")
    public String createProducts(Model model) {
        Product product = new Product();

        ProductService productService = new ProductService();

        System.out.println("List id category " + productService.getListNameCategory());

        model.addAttribute("listCategorys", productService.getListIdCategory());
        model.addAttribute("product", product);
        return "admin/form/createProducts";

    }

     // edit products 
     @GetMapping("products/edit/{id}")
     public String edit(Model model, @PathVariable("id") int id) {
 
         if (id != 0) {
             Product productEdit = productService.findProductsById(id);
             model.addAttribute("product", productEdit);
             model.addAttribute("listCategorys", productService.getListIdCategory());
             return "admin/form/editProducts";
         }
         return "redirect:/dashboard/products";
     }

     // edit products post
     @PostMapping("products/edit")
     public String createProducts(Model model, @Valid @ModelAttribute("product") Product dto,
             BindingResult result) {
         if (result.hasErrors()) {
             // đẩy lại view và đưa ra thông báo lỗi
             System.out.println("CO EROR");
             return "admin/form/createProducts";
         }
 
         Product copy = new Product();
         BeanUtils.copyProperties(dto, copy);
         System.out.println("copy: " + copy);
         productService.edit(copy);
         return "redirect:/dashboard/products";
 
     }
 
       // create products
     @PostMapping("products/create")
     public String editProducts(Model model, @Valid @ModelAttribute("product") Product dto,
             BindingResult result) {
         if (result.hasErrors()) {
             // đẩy lại view và đưa ra thông báo lỗi
             System.out.println("CO EROR");
             return "admin/form/createProducts";
         }
 
         Product copy = new Product();
         BeanUtils.copyProperties(dto, copy);
         System.out.println("copy: " + copy);
         productService.add(copy);
 
         return "redirect:/dashboard/products";
 
     }

    // delete product
    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {

        if (id != 0) {
            productService.remove(id);

        }

        return "redirect:/dashboard/products";
    }

}
