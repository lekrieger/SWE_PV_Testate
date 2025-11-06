// import java.util.Arrays;

// Testklasse / main-Klasse

public class GeometryTest {

   // Kleine Helfer-Methode, um Tests schneller zu schreiben
   private static void check(boolean condition, String message) {
      if (!condition) {
         throw new AssertionError("FEHLER: " + message);
      }
      System.out.println("OK: " + message);
   }

   public static void main(String[] args) {
      System.out.println("Starte Geometrie-Tests...");

      //  2D Tests 
      System.out.println("\n 2D Tests: ");
      Point2D pA = new Point2D(1, 1);
      Point2D pB = new Point2D(3, 3);
      
      check(pA.dimensions() == 2, "Point2D hat 2 Dimensionen");
      check(pA.volume() == 0.0, "Point2D Volumen ist 0");

      // Test encapsulate (a)
      Geometry rectAB = pA.encapsulate(pB);
      check(rectAB instanceof Rectangle, "encapsulate(Point2D, Point2D) ist Rectangle");
      check(rectAB.volume() == 4.0, "Volumen (Fläche) von rectAB ist 4.0 (2x2)");

      Point2D pC = new Point2D(0, 4);
      // Test encapsulate (b)
      Geometry rectABC = rectAB.encapsulate(pC);
      check(rectABC instanceof Rectangle, "encapsulate(Rectangle, Point2D) ist Rectangle");
      // Muss von (0,1) bis (3,4) gehen
      check(rectABC.volume() == 9.0, "Volumen von rectABC ist 9.0 (3x3)");

      Rectangle rD = new Rectangle(new Point2D(5, 5), new Point2D(6, 6));
      // Test encapsulate (c)
      Geometry rectABCD = rectABC.encapsulate(rD);
      check(rectABCD instanceof Rectangle, "encapsulate(Rectangle, Rectangle) ist Rectangle");
      // Muss von (0,1) bis (6,6) gehen
      check(rectABCD.volume() == 30.0, "Volumen von rectABCD ist 30.0 (6x5)");


      //  nD Tests (hier 3D)
      System.out.println("\n nD Tests (3D): ");
      Point p1 = new Point(1, 1, 1);
      Point p2 = new Point(3, 3, 3);

      check(p1.dimensions() == 3, "Point hat 3 Dimensionen");
      check(p1.volume() == 0.0, "Point Volumen ist 0");

      Geometry vol12 = p1.encapsulate(p2);
      check(vol12 instanceof Volume, "encapsulate(Point, Point) ist Volume");
      // 2x2x2 = 8
      check(vol12.volume() == 8.0, "Volumen von vol12 ist 8.0");

      Point p3 = new Point(0, 0, 0);
      Geometry vol123 = vol12.encapsulate(p3);
      check(vol123 instanceof Volume, "encapsulate(Volume, Point) ist Volume");
      // 3x3x3 = 27
      check(vol123.volume() == 27.0, "Volumen von vol123 ist 27.0");

      Volume vol4 = new Volume(new Point(5,5,5), new Point(6,6,6));
      Geometry vol1234 = vol123.encapsulate(vol4);
      check(vol1234 instanceof Volume, "encapsulate(Volume, Volume) ist Volume");
      // 6x6x6 = 216
      check(vol1234.volume() == 216.0, "Volumen von vol1234 ist 216.0");


      // Sonstige Tests
      System.out.println("\nSonstige Tests: ");
      // Dimensions-Check
      check(p1.encapsulate(pA) == null, "encapsulate(3D, 2D) ist null");
      check(pA.encapsulate(p1) == null, "encapsulate(2D, 3D) ist null");

      // Test Comparable
      check(pA.compareTo(pB) == 0, "compareTo(Point, Point) ist 0");
      check(rectAB.compareTo(rectABC) < 0, "compareTo(Vol 4, Vol 9) ist < 0");
      check(rectABC.compareTo(rectAB) > 0, "compareTo(Vol 9, Vol 4) ist > 0");
      
      // Test varargs
      Point p5d = new Point(1, 2, 3, 4, 5);
      check(p5d.dimensions() == 5, "Varargs Konstruktor für 5D Point funktioniert");


      System.out.println("\nAlle Tests erfolgreich abgeschlossen.");
   }
}