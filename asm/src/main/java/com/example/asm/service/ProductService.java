package com.example.asm.service;

import java.util.ArrayList;
import java.util.List;

import com.example.asm.dto.Category;
import com.example.asm.dto.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
        List<Product> list = new ArrayList<Product>();

        public void setList(List<Product> list) {
                this.list = list;
        }

        public ProductService() {
                list.add(new Product(1, "Oppo A71",
                                "https://thaymatkinhdanang.vn/wp-content/uploads/2018/05/thay-mat-kinh-oppo-a71.jpg",
                                "3000000", "no", 1));
                list.add(new Product(2, "Samsung A20",
                                "https://cdn.tgdd.vn/Products/Images/42/198792/samsung-galaxy-a20-red-600x600-1-600x600.jpg",
                                "3000000", "no", 2));
                list.add(new Product(3, "Iphone 10",
                                "https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-hh-600x600.jpg",
                                "3000000", "no", 3));
                list.add(new Product(4, "Xiaomi black shark",
                                "https://cdn.tgdd.vn/Products/Images/42/217844/xiaomi-black-shark-3-600x600-2-600x600.jpg",
                                "3000000", "no", 4));
                list.add(new Product(5, "Vsmart",
                                "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/thumbnail/9df78eab33525d08d6e5fb8d27136e95/v/s/vsmart-joy-4_2_.png",
                                "3000000", "no", 5));

        }

        public List<Product> getListProduct() {
                return this.list;
        }

        public List<String> getListNameCategory() {

                List<String> list = new ArrayList<String>();
                CategoryService service = new CategoryService();

                for (Category name : service.getListCategory()) {
                        list.add(name.getName());
                }
                return list;
        }

        public List<Integer> getListIdCategory() {

                List<Integer> list = new ArrayList<Integer>();
                CategoryService service = new CategoryService();

                for (Category name : service.getListCategory()) {
                        list.add(name.getId());
                }
                return list;
        }

        public List<Integer> convertId(String name) {

                List<Integer> list = new ArrayList<Integer>();
                CategoryService service = new CategoryService();

                for (Category item : service.getListCategory()) {
                        if (item.getName().equals(name)) {
                                list.add(item.getId());
                        }
                }
                return list;
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

        public boolean edit(Product cate) {
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

        public boolean add(Product cate) {
                try {
                        list.add(cate);
                        return true;
                } catch (Exception e) {
                        return false;
                }

        }

        
    public Product findProductsById(int id) {
        for (Product cate : list) {
            if (cate.getId() == id) {
                return cate;
            }
        }
        return null;
    }

        // public boolean add(Account acc) {
        // try {
        // // kiểm trra xem đã có username chưa
        // for (int i = 0; i <= list.size(); i++) {
        // if (list.get(i).getUsername().equals(acc.getUsername())) {
        // list.set(i, acc);

        // return true;
        // }
        // }
        // list.add(acc);
        // return true;
        // } catch (Exception e) {
        // return false;
        // }

        // }

        // public boolean remove(String username) {
        // try {
        // for (int i = 0; i <= list.size(); i++) {
        // if (list.get(i).getUsername().equals(username)) {
        // //xoá đi
        // list.remove(i);
        // return true;
        // }
        // }
        // return false;
        // } catch (Exception e) {
        // return false;
        // }
        // }

        // public Account findAccountByUsername(String username) {
        // for (Account account : list) {
        // if (account.getUsername().equals(username)) {
        // return account;
        // }
        // }
        // return null;
        // }
}
