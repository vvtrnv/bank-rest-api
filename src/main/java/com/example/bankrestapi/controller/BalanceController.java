package com.example.bankrestapi.controller;

import com.example.bankrestapi.model.TransferBalance;
import com.example.bankrestapi.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;


    @GetMapping("/{accountId}")
    private BigDecimal checkBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    private BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    private void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);
    }
}
