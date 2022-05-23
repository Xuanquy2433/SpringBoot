package com.example.asm.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.asm.dto.Category;
import com.example.asm.service.CategoryService;

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
public class CategoriesController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("categories")
    public String categories(Model model) {
        System.out.println("go here");

        List<Category> categorys = categoryService.getListCategory();
        model.addAttribute("categorys", categorys);
       

        return "admin/custom/categories";
    }

    @GetMapping("categories/create")
    public String createCategories(Model model) {
        System.out.println("go here create");

        Category categorys = new Category();
        model.addAttribute("category", categorys);
        return "admin/form/createCategories";

    }

    // edit categories get
    @GetMapping("categories/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {

        if (id != 0) {
            Category categoryEdit = categoryService.findCategoryById(id);
            System.out.println("List category edit: " + categoryEdit);
            model.addAttribute("categorys", categoryEdit);

            return "admin/form/editCategories";
        }
        return "redirect:/dashboard/categories";
    }

    // edit categories post
    @PostMapping("categories/edit")
    public String createCategoriesPost(Model model, @Valid @ModelAttribute("category") Category dto,
            BindingResult result) {
        if (result.hasErrors()) {
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR");
            return "admin/form/createCategories";
        }

        Category copy = new Category();
        BeanUtils.copyProperties(dto, copy);
        System.out.println("copy: " + copy);
        categoryService.edit(copy);
        return "redirect:/dashboard/categories";

    }

    // create categories
    @PostMapping("categories/create")
    public String edit(Model model, @Valid @ModelAttribute("category") Category dto,
            BindingResult result) {
        if (result.hasErrors()) {
            // đẩy lại view và đưa ra thông báo lỗi
            System.out.println("CO EROR");
            return "admin/form/createCategories";
        }

        Category copy = new Category();
        BeanUtils.copyProperties(dto, copy);
        System.out.println("copy edittt : " + copy);
        // result.rejectValue("username", "error.username.exists", "Add succsess.");
        categoryService.add(copy);

        return "redirect:/dashboard/categories";

    }

    // delete categories
    @GetMapping("categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model) {

        if (id != 0) {
            categoryService.remove(id);
        }

        return "redirect:/dashboard/categories";
    }

}
