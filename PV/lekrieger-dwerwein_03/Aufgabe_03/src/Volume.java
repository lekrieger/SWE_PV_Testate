// Ein n-dimensionales Volumen, speichert intern die min-Ecke (a) und max-Ecke (b)

public class Volume extends Geometry {

   // a = min-Ecke, b = max-Ecke
   private Point a;
   private Point b;

   public Volume(Point p1, Point p2) {
      super(p1.dimensions());

      // Dimensionen der Punkte müssen passen
      if (p1.dimensions() != p2.dimensions()) {
         throw new RuntimeException("Dimensionen der Punkte passen nicht zusammen");
      }

      int dims = dimensions();
      double[] minCoords = new double[dims];
      double[] maxCoords = new double[dims];

      // Min/Max für jede Dimension finden
      for (int i = 0; i < dims; i++) {
         minCoords[i] = Math.min(p1.getCoord(i), p2.getCoord(i));
         maxCoords[i] = Math.max(p1.getCoord(i), p2.getCoord(i));
      }
      
      this.a = new Point(minCoords);
      this.b = new Point(maxCoords);
   }

   // Getter für die Ecken
   public Point getA() {
      return a;
   }

   public Point getB() {
      return b;
   }

   @Override
   public double volume() {
      // Volumen ist das Produkt aller Kantenlängen
      double vol = 1.0;
      for (int i = 0; i < dimensions(); i++) {
         vol *= (b.getCoord(i) - a.getCoord(i));
      }
      return vol;
   }

   @Override
   public Geometry encapsulate(Geometry other) {
      if (other.dimensions() != this.dimensions()) {
         return null;
      }

      if (other instanceof Point) {
         // Point kann das schon
         return other.encapsulate(this);
      }

      if (other instanceof Volume) {
         // Volumen + Volumen = neues Volumen
         Volume v = (Volume) other;
         double[] minCoords = new double[dimensions()];
         double[] maxCoords = new double[dimensions()];

         for (int i = 0; i < dimensions(); i++) {
            minCoords[i] = Math.min(this.a.getCoord(i), v.getA().getCoord(i));
            maxCoords[i] = Math.max(this.b.getCoord(i), v.getB().getCoord(i));
         }

         return new Volume(new Point(minCoords), new Point(maxCoords));
      }

      throw new RuntimeException("Unbekannter nD-Geometrietyp");
   }
}