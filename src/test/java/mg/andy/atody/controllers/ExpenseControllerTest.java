package mg.andy.atody.controllers;

import mg.andy.atody.services.expenses.ExpenseService;
import mg.andy.atody.services.items.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExpenseController.class)
class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ItemService itemService;

    @MockitoBean
    private ExpenseService expenseService;
    ;

    @BeforeEach
    void setup() throws Exception {
        when(itemService.fetch()).thenReturn(List.of());
        when(itemService.getPrice(any())).thenReturn(BigDecimal.valueOf(15_000));
    }

    @Test
    void getItemAmount() throws Exception {
        this.mockMvc.perform(
                get("/expenses/1/amount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk());
    }
}