package ArtWebshop;

//Unterklasse für Gemälde
public class Gemälde extends Produkte {
 public enum Type { WATERCOLOR, OIL }
 private Type type;
 private boolean isOriginal; // True für Original, false für Druck

 public Gemälde(String title, double price, Type type, boolean isOriginal) {
     super(title, price);
     this.type = type;
     this.isOriginal = isOriginal;
 }

 @Override
 public String getDetails() {
     return "Painting (" + type + ") - " + (isOriginal ? "Original" : "Print");
 }
}