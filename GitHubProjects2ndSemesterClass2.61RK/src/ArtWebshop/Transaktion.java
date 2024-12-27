package ArtWebshop;

import java.util.ArrayList;
import java.util.List;

//Klasse für Transaktionen
public class Transaktion {
 private Kunden customer;
 private List<Produkte> products = new ArrayList<>();
 private double totalAmount;

 public Transaktion(Kunden customer) {
     this.customer = customer;
 }

 public void addProduct(Produkte product) {
     products.add(product);
     totalAmount += product.getPrice();
 }

 public double getTotalAmount() {
     return totalAmount;
 }

 public List<Produkte> getProducts() {
     return products;
 }

 @Override
 public String toString() {
     StringBuilder details = new StringBuilder("Transaction details:\n");
     for (Produkte product : products) {
         details.append(product.getTitle()).append(" - ").append(product.getDetails()).append("\n");
     }
     details.append("Total: ").append(totalAmount).append(" EUR");
     return details.toString();
 }
}