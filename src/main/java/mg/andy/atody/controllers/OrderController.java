package mg.andy.atody.controllers;

import mg.andy.atody.presentation.OrderRequest;
import mg.andy.atody.services.CustomerService;
import mg.andy.atody.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;
    private CustomerService customerService;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping
    public String createOrder(@ModelAttribute OrderRequest orderRequest, Model model) {
        log.info("Creating order : {}", orderRequest);
        orderService.createOrder(orderRequest);
        model.addAttribute("customers", customerService.fetch());
        model.addAttribute("order", new OrderRequest());
        model.addAttribute("orderList", orderService.getAll());
        return "sales";
    }
}
