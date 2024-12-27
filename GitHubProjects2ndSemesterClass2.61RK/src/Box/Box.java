package Box;

public class Box implements Comparable<Box> {

    private double width;
    private double height;
    private double depth;

    // Konstruktor
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Getter
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    // Berechnet das Volumen der Box
    public double getVolume() {
        return width * height * depth;
    }

    // Überschreibt die equals-Methode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box box = (Box) obj;
        return Double.compare(box.width, width) == 0 &&
               Double.compare(box.height, height) == 0 &&
               Double.compare(box.depth, depth) == 0;
    }

    // Überschreibt die compareTo-Methode, um Boxen nach Volumen zu ordnen
    @Override
    public int compareTo(Box other) {
        return Double.compare(this.getVolume(), other.getVolume());
    }

    // String-Darstellung für Debugging
    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", volume=" + getVolume() +
                '}';
    }
}