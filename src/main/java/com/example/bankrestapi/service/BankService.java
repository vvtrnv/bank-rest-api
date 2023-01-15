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
            throw new IllegalArgumentException("Not find id in get balance");
        }

        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = balanceRepo.getBalanceForId(to);

        if (currentBalance == null) {
            balanceRepo.save(to, amount);
            return amount;
        } else {
            BigDecimal updatedBalance = currentBalance.add(amount);
            balanceRepo.save(to, updatedBalance);
            return updatedBalance;
        }
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal balanceFrom = balanceRepo.getBalanceForId(transferBalance.getFrom());
        BigDecimal balanceTo = balanceRepo.getBalanceForId(transferBalance.getTo());

        if (balanceFrom == null || balanceTo == null) {
            throw new IllegalArgumentException("Balance is empty");
        }

        if (transferBalance.getAmount().compareTo(balanceFrom) > 0) {
            throw new IllegalArgumentException("No money");
        }

        BigDecimal updatedBalanceFrom = balanceFrom.subtract(transferBalance.getAmount());
        BigDecimal updatedBalanceTo = balanceTo.add(transferBalance.getAmount());

        balanceRepo.save(transferBalance.getFrom(), updatedBalanceFrom);
        balanceRepo.save(transferBalance.getTo(), updatedBalanceTo);
    }
}
