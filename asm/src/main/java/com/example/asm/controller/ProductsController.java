package com.example.asm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.asm.domain.Category;
import com.example.asm.domain.Products;
import com.example.asm.dto.ProductDto;
import com.example.asm.service.CategoryService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("dashboard")
public class ProductsController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("products")
    public String products(Model model) {
        List<Products> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/custom/products";
    }

    @ModelAttribute("categorys")
    public List<Category> list() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    @GetMapping("products/create")
    public String createProducts(Model model) {

        ProductDto product = new ProductDto();
        model.addAttribute("products", product);
        // List<Categories> categories = categoryService.findAll();
        // model.addAttribute("categorys", categories);
        return "admin/form/createProducts";

    }

    @PostMapping("products/create")
    public String createProduct(Model model, @Valid @ModelAttribute("products") ProductDto dto,
            BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR  " + result);
            return "admin/form/createProducts";
        }

        Category category = new Category();
        category.setCategoryId(dto.getCategory());

        Products copy = new Products();
        copy.setCategory(category);
        // copy.setActivated(dto.get);
        BeanUtils.copyProperties(dto, copy);
        System.err.println("copy product : " + copy);
        productService.save(copy);
        redirectAttributes.addFlashAttribute("success", "Add succsess");
        return "redirect:/dashboard/products";

    }

    // edit products
    @GetMapping("products/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {

        if (id != 0) {
            Optional<Products> prd = productService.findById(id);
            if (prd.isPresent()) {
                model.addAttribute("products", prd.get());
                return "admin/form/editProducts";
            }
        }
        return "redirect:/dashboard/editProducts";
    }

    // edit products post
    @PostMapping("products/edit")
    public String update(Model model, @Valid @ModelAttribute("products") ProductDto dto,
            RedirectAttributes redirectAttributes,
            BindingResult result) {
        if (result.hasErrors()) {
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR  " + result);
            return "admin/form/editProducts";
        }

        Category category = new Category();
        category.setCategoryId(dto.getCategory());

        Products copy = new Products();
        copy.setCategory(category);
        BeanUtils.copyProperties(dto, copy);
        System.err.println("copy product : " + copy);
        productService.save(copy);
        redirectAttributes.addFlashAttribute("success", "Update succsess");
        return "redirect:/dashboard/products";
    }

    @GetMapping("products/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            RedirectAttributes redirAttrs) {
        if (id != 0) {
            Optional<Products> detail = productService.findById(id);
            if (detail.isPresent()) {
                productService.delete(detail.get());
                redirAttrs.addFlashAttribute("success", "Xóa thành công");
                return "redirect:/dashboard/products";
            }
        }
        return "redirect:/dashboard/products";
    }

    // ProductDto copy = new ProductDto();
    // BeanUtils.copyProperties(dto, copy);
    // System.out.println("copy: " + copy);
    // productService.edit(copy);
    // return "redirect:/dashboard/products";

    // }

    // ProductDto copy = new ProductDto();
    // BeanUtils.copyProperties(dto, copy);
    // System.out.println("copy: " + copy);
    // productService.add(copy);

    // return "redirect:/dashboard/products";

    // }

    // // delete product
    // @GetMapping("products/delete/{id}")
    // public String deleteProduct(@PathVariable("id") int id, Model model) {

    // if (id != 0) {
    // productService.remove(id);

    // }

    // return "redirect:/dashboard/products";
    // }

}
