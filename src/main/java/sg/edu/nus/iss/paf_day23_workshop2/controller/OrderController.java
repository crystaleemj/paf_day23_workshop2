package sg.edu.nus.iss.paf_day23_workshop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.paf_day23_workshop2.model.Order;
import sg.edu.nus.iss.paf_day23_workshop2.service.OrderSvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping
public class OrderController {
    @Autowired
    OrderSvc svc;

    @GetMapping()
    public String inputPage() {
        return "input.html";
    }
    
    
    @GetMapping(path = "/order/total/{order_id}")
    public String listOrderByID(@PathVariable Integer order_id, Order order, Model model) {

        List<Order> list = svc.listOrder(order_id);
        model.addAttribute("list", list);

        return "order.html";
    }

    @GetMapping(path = "/order")
    public String redirect(@RequestParam Integer order_id) {
        return "redirect:/order/total/" + order_id;
    }
    
    
}
