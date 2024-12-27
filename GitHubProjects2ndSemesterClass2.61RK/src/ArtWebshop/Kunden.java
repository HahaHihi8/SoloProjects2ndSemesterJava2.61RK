package ArtWebshop;

import java.util.ArrayList;
import java.util.List;

public class Kunden {
    private String name;
    private String email;
    private String billingAddress;
    private String deliveryAddress;
    private List<Transaktion> transactions = new ArrayList<>();

    public Kunden(String name, String email, String billingAddress, String deliveryAddress) {
        this.name = name;
        this.email = email;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void addTransaction(Transaktion transaction) {
        transactions.add(transaction);
    }

    public List<Transaktion> getTransactions() {
        return transactions;
    }
}