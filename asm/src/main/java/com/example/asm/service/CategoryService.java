package com.example.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.example.asm.dto.Category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    List<Category> list = new ArrayList<Category>();

    public void setList(List<Category> list) {
        this.list = list;
    }

    public CategoryService() {
        list.add(new Category(1, "Oppo", "https://bvtmobile.com/uploads/source/iphone-13/iphone-13-pro-xanh-la.jpg",
                "none"));
        list.add(new Category(2, "Samsung", "https://bvtmobile.com/uploads/source/iphone-13/iphone-13-pro-xanh-la.jpg",
                "none"));
        list.add(new Category(3, "Iphone", "https://bvtmobile.com/uploads/source/iphone-13/iphone-13-pro-xanh-la.jpg",
                "none"));
        list.add(new Category(4, "Xiaomi", "https://bvtmobile.com/uploads/source/iphone-13/iphone-13-pro-xanh-la.jpg",
                "none"));
        list.add(new Category(5, "Redmi", "https://bvtmobile.com/uploads/source/iphone-13/iphone-13-pro-xanh-la.jpg",
                "none"));

    }

    public List<Category> getListCategory() {
        return this.list;
    }

    public boolean remove(int id) {
        try {
            for (int i = 0; i <= list.size(); i++) {
                if (list.get(i).getId() == id) {
                    // xoá đi
                    list.remove(i);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean edit(Category cate) {
        try {
            // kiểm trra xem đã có username chưa
            for (int i = 0; i <= list.size(); i++) {
                if (list.get(i).getId() == cate.getId()) {
                    list.set(i, cate);
                    return true;
                }
            }
            list.add(cate);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean add(Category cate) {
        try {
            System.out.println("hihihihih: " + this.getListCategory());
            list.add(cate);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Category findCategoryById(int id) {
        for (Category cate : list) {
            if (cate.getId() == id) {
                return cate;
            }
        }
        return null;
    }
}
