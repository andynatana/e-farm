package mg.andy.atody.controllers;

import mg.andy.atody.presentation.request.ExpenseRequest;
import mg.andy.atody.services.expenses.ExpenseService;
import mg.andy.atody.services.items.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private static final Logger log = LoggerFactory.getLogger(ExpenseController.class);
    private ItemService itemService;
    private ExpenseService expenseService;

    public ExpenseController() {
    }

    @Autowired
    public ExpenseController(ItemService itemService, ExpenseService expenseService) {
        this.itemService = itemService;
        this.expenseService = expenseService;
    }

    @GetMapping
    public String presentHome(Model model) {
        model.addAttribute("expenseRequest", new ExpenseRequest());
        model.addAttribute("expensesItems", itemService.fetch());
        return "expenses";
    }

    @PostMapping
    public String createExpense(@ModelAttribute ExpenseRequest expenseRequest, Model model) {
        log.info("Expense request : {}", expenseRequest);
        expenseService.create(expenseRequest);
        return "redirect:/expenses";
    }
}
