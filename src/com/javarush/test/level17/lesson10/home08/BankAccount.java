package com.javarush.test.level17.lesson10.home08;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(BigDecimal money) {
        synchronized (BankAccount.class)
        {
            BigDecimal newBalance = balance.add(money);
            System.out.println("Добавляем " + money + ", на счету " + newBalance);
            balance = newBalance;
        }
    }

    public void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        synchronized (BankAccount.class) {
            BigDecimal newBalance = balance.subtract(money);

            if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

            balance = newBalance;
            System.out.println("Тратим " + money + ", на счету " + balance);
        }
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
