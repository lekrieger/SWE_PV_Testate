//  einfacher 2D-Punkt (Hat kein Volumen)

public class Point2D extends Geometry {

   private double x;
   private double y;

   public Point2D(double x, double y) {
      // 2D
      super(2);
      this.x = x;
      this.y = y;
   }

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   @Override
   public double volume() {
      // Ein Punkt hat kein Volumen
      return 0.0;
   }

   @Override
   public Geometry encapsulate(Geometry other) {
      // Dimensionen müssen passen
      if (other.dimensions() != 2) {
         return null;
      }

      if (other instanceof Point2D) {
         // Punkt + Punkt = Rechteck (siehe Bild a)
         return new Rectangle(this, (Point2D) other);
      }

      if (other instanceof Rectangle) {
         // Punkt + Rechteck = neues Rechteck (siehe Bild b)
         Rectangle r = (Rectangle) other;
         // Min/Max-Koordinaten finden
         double minX = Math.min(this.x, r.getA().getX());
         double minY = Math.min(this.y, r.getA().getY());
         double maxX = Math.max(this.x, r.getB().getX());
         double maxY = Math.max(this.y, r.getB().getY());

         return new Rectangle(new Point2D(minX, minY), new Point2D(maxX, maxY));
      }

      // falls unbekannter Typ
      throw new RuntimeException("Unbekannter 2D-Geometrietyp");
   }
}