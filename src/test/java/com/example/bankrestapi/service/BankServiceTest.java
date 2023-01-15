package com.example.bankrestapi.service;

import com.example.bankrestapi.repository.BalanceRepo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BalanceRepo balanceRepo = new BalanceRepo();
    private BankService bankService = new BankService(balanceRepo);

    @Test
    void getBalance() {
        BigDecimal balance = bankService.getBalance(1L);

        assertEquals(balance, BigDecimal.TEN);
    }

    @Test
    void addMoney() {
        BigDecimal balance = bankService.addMoney(1L, BigDecimal.ONE);


        assertEquals(balance, BigDecimal.valueOf(11));
    }
}