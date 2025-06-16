package com.example.demo;

public class BankAccount {

    private final String accountId = "1234567";
    private final String accountPW = "1234";
    private int balance = 0;

    public boolean authenticate(String id, String pw) {
        if (accountId.equals(id) && accountPW.equals(pw)) {
            return true;
        } else {
            throw new IllegalArgumentException("IDかパスワードが間違っています");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("1円以上の入金をしてください");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("1円以上の出金をしてください");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("残高が足りません");
        }
        balance -= amount;
    }
}