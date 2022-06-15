package com.example.asm.controller;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.example.asm.domain.Account;
import com.example.asm.domain.Order;
import com.example.asm.domain.OrderDetail;
import com.example.asm.domain.OrderDetailKey;
import com.example.asm.domain.Products;
import com.example.asm.dto.CartDto;
import com.example.asm.dto.ItemDto;
import com.example.asm.dto.OrderDto;
import com.example.asm.dto.QuantityDto;
import com.example.asm.service.AccountService;
import com.example.asm.service.MailService;
import com.example.asm.service.OrderDetailService;
import com.example.asm.service.OrderService;
import com.example.asm.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    MailService mailService;

    @GetMapping("")
    public String cart(Model model) {
        return "cart";
    }

    @GetMapping("checkout")
    public String checkout(Model model) {
        OrderDto order = new OrderDto();
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping("checkout")
    public String createCheckout(@Valid @ModelAttribute("order") OrderDto dto,
            BindingResult result,
            RedirectAttributes redirAttrs) throws MessagingException {

        if (result.hasErrors()) {
            System.out.print("loi");
            // đẩy lại view và đưa ra thông báo lỗi
            return "checkout";
        }
        // save Order first
        Order order = new Order();
        BeanUtils.copyProperties(dto, order);
        String username = (String) httpSession.getAttribute("username");
        Account account = accountService.getById(username);
        order.setAccount(account);
        CartDto cart = (CartDto) httpSession.getAttribute("cart");
        order.setTotal(cart.total());
        order.setStatus(1);
        Order orderCreated = orderService.save(order);
        for (ItemDto item : cart.getCarts()) {
            OrderDetail orderDetail = new OrderDetail();
            OrderDetailKey key = new OrderDetailKey(order.getId(), item.getMaSp());
            orderDetail.setId(key);
            orderDetail.setOrder(order);
            Products product = new Products();
            product.setId(item.getMaSp());
            orderDetail.setProduct(product);
            orderDetail.setPrice(item.getPrice());
            orderDetail.setQuantity(item.getSoLuong());

            orderDetail.setTotal(item.getPrice() * item.getSoLuong());

            orderDetailService.save(orderDetail);
            // mailService.sendAsHtml("truongvan6322@gmail.com", "Đơn hàng c", " <table
            // class=\"table\">\n"
            // + " <thead class=\"thead-primary\">\n"
            // + " <tr class=\"text-center\">\n"
            // + " <th scope=\"col\">Id</th>\n"
            // + " <th scope=\"col\">Name</th>\n"
            // + " <th scope=\"col\">Note</th>\n"
            // + " <th scope=\"col\">Phone</th>\n"
            // + " <th scope=\"col\">Status</th>\n"
            // + " <th scope=\"col\">Total</th>\n"
            // + " <th scope=\"col\">username</th>\n"
            // + " </tr>\n"
            // + "\n"
            // + "\n"
            // + " </thead>\n"
            // + " <tbody >\n"
            // + "\n"
            // + " <tr class=\"text-center\">\n"
            // + " \n"
            // + "\n"
            // + " <td > " + order.getId() + " </td>\n"
            // + "\n"
            // + "\n"
            // + " <td class=\"product-name\">\n"
            // + order.getCustomerName()
            // + "\n"
            // + " </td>\n"
            // + " <td style=\"width: 8%;\" class=\"image-prod\">\n"
            // + " <img style=\"width: 100%;height: 70px;\"\n"
            // + " src=\" " + order.getNote() + " \" class=\"img\">\n"
            // + " </td>\n"
            // + "\n"
            // + " <td > " + order.getPhone() + " </td>\n"
            // + " <td > " + order.getStatus() + " </td>\n"
            // + " <td > " + order.getTotal() + " </td>\n"
            // + "\n"
            // + "\n"
            // + " </tbody>\n"
            // + " </table> ");
            redirAttrs.addFlashAttribute("success", "Checkout success");
        }
        return "SuccsessPage";
    }

    @Autowired
    HttpSession httpSession;

    @GetMapping("addCart/{id}")
    public String add(Model model,
            @PathVariable("id") int productId,
            RedirectAttributes redirAttrs) {
        if (productId != 0) {
            /**
             * step 1: lấy detail product step 2: kiểm tra xem cart session có
             * tồn tại chưa + chưa thì tạo mới step 3: tao itemDTO và add vào
             * cart step 4: reset cart -> cart list
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
                    redirAttrs.addFlashAttribute("success", "Đã cập nhật vào giỏ hàng");
                } else {
                    carts = new CartDto();
                    carts.add(item);
                    // tạo mới cart
                    redirAttrs.addFlashAttribute("success", "Đã thêm vào giỏ hàng");
                }
                httpSession.setAttribute("cart", carts);
            }
        }
        return "redirect:/cart";
    }

    @PostMapping("addCartQuantity/{id}")
    public String search(Model model, @ModelAttribute("getQuantity") QuantityDto quantityDto,
            @PathVariable("id") int productId,
            RedirectAttributes redirAttrs) {

        System.err.println("Quantity  " + quantityDto.getQuantity());
        if (productId != 0) {
            /**
             * step 1: lấy detail product step 2: kiểm tra xem cart session có
             * tồn tại chưa + chưa thì tạo mới step 3: tao itemDTO và add vào
             * cart step 4: reset cart -> cart list
             */
            CartDto carts = (CartDto) httpSession.getAttribute("cart");
            Optional<Products> detail = productService.findById(productId);
            ItemDto item = new ItemDto();
            if (detail != null) {
                item.setMaSp(detail.get().getId());
                item.setSoLuong(quantityDto.getQuantity());
                item.setPrice(detail.get().getPrice());
                item.setTitle(detail.get().getName());
                item.setImage(detail.get().getImage());
                if (carts != null) {
                    // có cart
                    carts.add(item);
                    redirAttrs.addFlashAttribute("success", "Đã cập nhập giỏ hàng");
                } else {
                    carts = new CartDto();
                    carts.add(item);
                    // tạo mới cart
                    redirAttrs.addFlashAttribute("success", "Đã thêm vào giỏ hàng");
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
             * step 1: lấy detail product step 2: kiểm tra xem cart session có
             * tồn tại chưa + chưa thì tạo mới step 3: tao itemDTO và add vào
             * cart step 4: reset cart -> cart list
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
                redirAttrs.addFlashAttribute("success", "Đã xóa khỏi giỏ hàng");
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
                redirAttrsAttributes.addFlashAttribute("success", "Đã giảm số lượng sản phẩm");
            }
        }
        return "redirect:/cart";
    }
}
