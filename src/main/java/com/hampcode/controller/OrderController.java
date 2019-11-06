package com.hampcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hampcode.model.entity.Order;
import com.hampcode.model.entity.OrderDetail;
import com.hampcode.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public String showAllOrders(Model model) {
		try {
			model.addAttribute("orders", this.orderService.getAll());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "orders/list";
	}
	
	@GetMapping("/new")
	public String newOrderForm(Model model) {
		try {			
			model.addAttribute("order", new Order());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "orders/new";
	}
	
	@PostMapping("/save")
	public String saveNewOrder(Order order, OrderDetail orderDetail, Model model) {
		try {						
			this.orderService.create(order);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/orders";
	}
	
}
