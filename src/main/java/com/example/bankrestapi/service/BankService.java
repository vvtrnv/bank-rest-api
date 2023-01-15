package com.example.bankrestapi.service;

import com.example.bankrestapi.model.TransferBalance;
import com.example.bankrestapi.repository.BalanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepo balanceRepo;
    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance = balanceRepo.getBalanceForId(accountId);

        if (balance == null) {
            throw new IllegalArgumentException("Balance is empty");
        }

        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance) {

    }
}
