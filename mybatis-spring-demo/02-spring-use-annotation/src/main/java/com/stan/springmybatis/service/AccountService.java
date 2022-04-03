//package com.stan.springmybatis.service;
//
///**
// * @Author：stanzeng
// * @Description：
// * @Date ：Created in 2020/6/11 10:16 上午
// * @Modified By：
// */
//
//interface MoneyTransferService {
//
//}
//
//public class MoneyTransferServiceTransactionScriptImpl implements MoneyTransferService {
//    private AccountDao accountDao;
//    private BankingTransactionRepository bankingTransactionRepository;
//
//    @Override
//    public BankingTransaction transfer(String fromAccountId, String toAccountId, double amount) {
//        Account fromAccount = accountDao.findById(fromAccountId);
//        Account toAccount = accountDao.findById(toAccountId);    . . .
//        double newBalance = fromAccount.getBalance() - amount;
//        switch (fromAccount.getOverdraftPolicy()) {
//            case NEVER:
//                if (newBalance < 0) {
//                    throw new DebitException("Insufficient funds");
//                }
//                break;
//            case ALLOWED:
//                if (newBalance < -limit) {
//                    throw new DebitException("Overdraft limit (of " + limit + ") exceeded: " + newBalance);
//                }
//                break;
//        }
//        fromAccount.setBalance(newBalance);
//        toAccount.setBalance(toAccount.getBalance() + amount);
//        BankingTransaction moneyTransferTransaction = new MoneyTranferTransaction(fromAccountId, toAccountId, amount);
//        bankingTransactionRepository.addTransaction(moneyTransferTransaction);
//        return moneyTransferTransaction;
//    }
//}
//
//// DDD
////*********************************************************************************
//
//// @Entity
//class Account {
//    private String id;
//    private double balance;
//    private OverdraftPolicy overdraftPolicy;
//
//    public double balance() {
//        return balance;
//    }
//
//    public void debit(double amount) {
//        this.overdraftPolicy.preDebit(this, amount);
//        this.balance = this.balance - amount;
//        this.overdraftPolicy.postDebit(this, amount);
//    }
//
//    public void credit(double amount) {
//        this.balance = this.balance + amount;
//    }
//}
//
//interface OverdraftPolicy {
//    void preDebit(Account account, double amount);
//
//    void postDebit(Account account, double amount);
//}
//
//public class NoOverdraftAllowed implements OverdraftPolicy {
//    public void preDebit(Account account, double amount) {
//        double newBalance = account.balance() - amount;
//        if (newBalance < 0) {
//            throw new DebitException("Insufficient funds");
//        }
//    }
//
//    public void postDebit(Account account, double amount) {
//    }
//}
//
//public class LimitedOverdraft implements OverdraftPolicy {
//    private double limit;
//
//    public void preDebit(Account account, double amount) {
//        double newBalance = account.balance() - amount;
//        if (newBalance < -limit) {
//            throw new DebitException("Overdraft limit (of " + limit + ") exceeded: " + newBalance);
//        }
//    }
//
//    public void postDebit(Account account, double amount) {
//    }
//}
//
//public class MoneyTransferServiceDomainModelImpl implements MoneyTransferService {
//    private AccountRepository accountRepository;
//    private BankingTransactionRepository bankingTransactionRepository;
//
//    @Override
//    public BankingTransaction transfer(String fromAccountId, String toAccountId, double amount) {
//        Account fromAccount = accountRepository.findById(fromAccountId);
//        Account toAccount = accountRepository.findById(toAccountId);
//        fromAccount.debit(amount);
//        toAccount.credit(amount);
//        BankingTransaction moneyTransferTransaction = new MoneyTranferTransaction(fromAccountId, toAccountId, amount);
//        bankingTransactionRepository.addTransaction(moneyTransferTransaction);
//        return moneyTransferTransaction;
//    }
//}