package mg.andy.atody.controllers;

import mg.andy.atody.presentation.request.OrderRequest;
import mg.andy.atody.services.customers.CustomerService;
import mg.andy.atody.services.orders.OrderBoardService;
import mg.andy.atody.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    private CustomerService customerService;
    private OrderService orderService;
    private OrderBoardService orderBoardService;

    public HomeController() {
    }

    @Autowired
    public HomeController(CustomerService customerService, OrderService orderService, OrderBoardService orderBoardService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.orderBoardService = orderBoardService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("orderBoard", orderBoardService.getOrderBoardStat());
        model.addAttribute("orderRequest", new OrderRequest());
        model.addAttribute("customers", customerService.fetch());
        model.addAttribute("orderList", orderService.getAll());
        return "sales";
    }
}
