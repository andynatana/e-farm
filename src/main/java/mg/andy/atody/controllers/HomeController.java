package mg.andy.atody.controllers;

import mg.andy.atody.presentation.OrderRequest;
import mg.andy.atody.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    private CustomerService customerService;

    public HomeController() {
    }

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("orderRequest", new OrderRequest());
        model.addAttribute("customers", customerService.fetch());
        return "sales";
    }
}
