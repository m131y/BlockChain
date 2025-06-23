package org.example;

public class Transaction {
    private final String sender;
    private final String receiver;
    private final double amount;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public double getAmount() { return  amount; }

    @Override
    public String toString() {
        return sender + "→" + receiver + ":" + amount;
    }
}