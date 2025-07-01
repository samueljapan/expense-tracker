package com.KIT.expensetracker.service;

import com.KIT.expensetracker.model.Expense;
import com.KIT.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    public Expense saveExpense(Expense expense) {
        return repo.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }
}
