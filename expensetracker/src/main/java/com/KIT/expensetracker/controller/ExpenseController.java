package com.KIT.expensetracker.controller;

import com.KIT.expensetracker.model.Expense;
import com.KIT.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }
    
    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteExpense(id);
    }
}
