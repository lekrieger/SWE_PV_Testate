//  n-dimensionaler Punkt, quasi die Verallgemeinerung von Point2D

public class Point extends Geometry {

   // Koordinaten speichern
   private double[] coords;

   /**
    * Varargs-Konstruktor für n-dimensionale Punkte
    *
    * @param coords die Koordinaten
    */

   public Point(double... coords) {
      // Dimension ist die Anzahl der Koordinaten
      super(coords.length);
      // Array klonen, sonst kann es von außen geändert werden
      this.coords = coords.clone();
   }

   // Getter für eine Koordinate in einer bestimmten Dimension, braucht man für Volume
   
   public double getCoord(int dim) {
      if (dim < 0 || dim >= dimensions()) {
         throw new IndexOutOfBoundsException("Dimension nicht vorhanden");
      }
      return coords[dim];
   }

   @Override
   public double volume() {
      // Punkt hat kein Volumen
      return 0.0;
   }

   @Override
   public Geometry encapsulate(Geometry other) {
      // Dimensionen müssen gleich sein
      if (other.dimensions() != this.dimensions()) {
         return null;
      }

      if (other instanceof Point) {
         // Punkt + Punkt = Volumen
         return new Volume(this, (Point) other);
      }

      if (other instanceof Volume) {
         // Punkt + Volumen = neues Volumen
         Volume v = (Volume) other;
         double[] minCoords = new double[dimensions()];
         double[] maxCoords = new double[dimensions()];

         // Min/Max für jede Dimension finden
         for (int i = 0; i < dimensions(); i++) {
            minCoords[i] = Math.min(this.getCoord(i), v.getA().getCoord(i));
            maxCoords[i] = Math.max(this.getCoord(i), v.getB().getCoord(i));
         }

         return new Volume(new Point(minCoords), new Point(maxCoords));
      }

      // Unbekannter nD-Typ
      throw new RuntimeException("Unbekannter nD-Geometrietyp");
   }
}