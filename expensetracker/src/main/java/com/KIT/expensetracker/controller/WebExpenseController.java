package com.KIT.expensetracker.controller;

import com.KIT.expensetracker.model.Expense;
import com.KIT.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebExpenseController {

    @Autowired
    private ExpenseRepository repo;

    
    @GetMapping("/")
    public String showExpenses(Model model) {
        model.addAttribute("expenses", repo.findAll());
        model.addAttribute("expense", new Expense()); 
        return "expense"; 
    }

    
    @PostMapping("/saveExpense")
    public String addExpense(@ModelAttribute Expense expense) {
        repo.save(expense);
        return "redirect:/";
    }

   
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
