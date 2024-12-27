package ArtWebshop;

//Unterklasse für Skulpturen
public class Skulpturen extends Produkte {
 public enum Material { WOOD, CLAY, BRONZE }
 private Material material;
 private boolean isUnique; // True für Holz/Ton, false für Bronze

 public Skulpturen(String title, double price, Material material, boolean isUnique) {
     super(title, price);
     this.material = material;
     this.isUnique = isUnique;
 }

 @Override
 public String getDetails() {
     return "Sculpture made of " + material + (isUnique ? " (Unique)" : " (Multiple copies)");
 }
}