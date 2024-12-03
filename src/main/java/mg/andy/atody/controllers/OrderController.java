package mg.andy.atody.controllers;

import mg.andy.atody.presentation.OrderRequest;
import mg.andy.atody.services.customers.CustomerService;
import mg.andy.atody.services.orders.OrderPersistenceService;
import mg.andy.atody.services.orders.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;
    private CustomerService customerService;
    private OrderPersistenceService orderPersistenceService;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService, OrderPersistenceService orderPersistenceService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.orderPersistenceService = orderPersistenceService;
    }

    @PostMapping
    public String createOrder(@ModelAttribute OrderRequest orderRequest, Model model) {
        log.info("Creating order : {}", orderRequest);
        orderPersistenceService.createOrder(orderRequest);
        return "redirect:/";
    }

    @GetMapping("/{orderId}/remove")
    public String remove(@PathVariable Long orderId) {
        log.info("Removing order : {}", orderId);
        orderPersistenceService.removeOrder(orderId);
        return "redirect:/";
    }
}
