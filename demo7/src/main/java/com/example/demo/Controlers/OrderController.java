package com.example.demo.Controlers;

import com.example.demo.Models.Order;
import com.example.demo.Service.OrderService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("order", new Order());
        return "order-create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-dd") Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders/list";
    }


    @GetMapping("/update/{id}")
    public String updateOrderForm(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("order", order);
        return "order-update";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute Order order) {
        order.setOrderId(id);
        orderService.saveOrder(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders/list";
    }
}
