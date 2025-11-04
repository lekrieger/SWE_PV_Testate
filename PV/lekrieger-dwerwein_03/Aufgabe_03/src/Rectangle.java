// Ein achsenparalleles Rechteck, speichert intern immer die untere linke (a) und obere rechte (b) Ecke
 
public class Rectangle extends Geometry {

   // a = min-Ecke, b = max-Ecke
   private Point2D a;
   private Point2D b;

   public Rectangle(Point2D p1, Point2D p2) {
      super(2);

      // Sicherstellen, dass a immer min (unten-links) und b immer max (oben-rechts) ist
      double minX = Math.min(p1.getX(), p2.getX());
      double minY = Math.min(p1.getY(), p2.getY());
      double maxX = Math.max(p1.getX(), p2.getX());
      double maxY = Math.max(p1.getY(), p2.getY());

      this.a = new Point2D(minX, minY);
      this.b = new Point2D(maxX, maxY);
   }

   // Getter für die Ecken, falls man sie braucht (z.B. in Point2D)
   public Point2D getA() {
      return a;
   }

   public Point2D getB() {
      return b;
   }

   @Override
   public double volume() {
      // Volumen im 2D-Fall ist die Fläche
      double width = b.getX() - a.getX();
      double height = b.getY() - a.getY();
      return width * height;
   }

   @Override
   public Geometry encapsulate(Geometry other) {
      if (other.dimensions() != 2) {
         return null;
      }

      if (other instanceof Point2D) {
         // Point2D kann das schon
         return other.encapsulate(this);
      }

      if (other instanceof Rectangle) {
         // Rechteck + Rechteck = neues Rechteck (Bild c)
         Rectangle r = (Rectangle) other;
         // Min/Max finden
         double minX = Math.min(this.a.getX(), r.getA().getX());
         double minY = Math.min(this.a.getY(), r.getA().getY());
         double maxX = Math.max(this.b.getX(), r.getB().getX());
         double maxY = Math.max(this.b.getY(), r.getB().getY());

         return new Rectangle(new Point2D(minX, minY), new Point2D(maxX, maxY));
      }

      throw new RuntimeException("Unbekannter 2D-Geometrietyp");
   }
}