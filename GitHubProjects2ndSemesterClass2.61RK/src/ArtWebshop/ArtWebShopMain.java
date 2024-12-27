package ArtWebshop;

public class ArtWebShopMain {

	public static void main(String[] args) {
        // Produkte erstellen
        Skulpturen sculpture1 = new Skulpturen("Bronze Statue", 1200.0, Skulpturen.Material.BRONZE, false);
        Gemälde painting1 = new Gemälde("Sunset", 800.0, Gemälde.Type.OIL, true);
        Gemälde painting2 = new Gemälde("Sea View", 200.0, Gemälde.Type.WATERCOLOR, false);

        // Kunde erstellen
        Kunden customer = new Kunden(
            "Alice",
            "alice@example.com",
            "123 Main St, Billing City",
            "456 Delivery Ln, Shipping Town"
        );

        // Transaktion erstellen
        Transaktion transaction = new Transaktion(customer);
        transaction.addProduct(sculpture1);
        transaction.addProduct(painting1);
        transaction.addProduct(painting2);

        // Transaktion dem Kunden hinzufügen
        customer.addTransaction(transaction);

        // Ausgabe der Transaktionsdetails
        System.out.println(transaction);

        // Alle Transaktionen des Kunden anzeigen
        System.out.println("\nAll Transactions for " + customer.getName() + ":");
        for (Transaktion t : customer.getTransactions()) {
            System.out.println(t);
        }
    }
}