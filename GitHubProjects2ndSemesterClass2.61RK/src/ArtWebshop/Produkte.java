package ArtWebshop;
//Basisklasse für alle Produkte
//abstract, kann nicht als Objekt benutzt werden
public abstract class Produkte { 	
    private String title;
    private double price;

    public Produkte(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDetails(); // Muss von Unterklassen implementiert werden
}