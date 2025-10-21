public class FractionTest {
    
    public static void main(String[] args) {

        Fraction f1 = new Fraction(5, -10);
        System.out.println("Test mit Fraction(5,-10): "+ f1);

        Fraction f2 = new Fraction(7);
        System.out.println("\nTest Ganzzahl-Konstruktor: new Fraction(7) -> " + f2 ); 

        Fraction f3 = new Fraction(2, 3);
        Fraction resultMultiplyInt = f3.multiply(5);
        System.out.println("\nTest multiply(int): (2/3) * 5 -> " + resultMultiplyInt);

        Fraction f4 = new Fraction(1, 2);
        Fraction resultMultiplyFraction = f4.multiply(new Fraction(3, 4));
        System.out.println("\nTesten multiply(Fraction) (Multiplizieren von zwei Brüchen): (1/2) * (3/4) -> " + resultMultiplyFraction); 

        Fraction f5 = new Fraction(1, 2);
        Fraction resultDivison = f5.divide(new Fraction(3, 4));
        System.out.println("\nTest divide(Fraction): (1/2) / (3/4) -> " + resultDivison);

        Fraction f6 = new Fraction(1, 2);
        Fraction resultMultiply = f6.multiply(new Fraction(2, 3), new Fraction(3, 5));
        System.out.println("\nTest von Multiplizieren mehrerer (...): (1/2) * (2/3) * (3/5) -> " + resultMultiply); 

        System.out.println("\nDas war eine kack-Aufgabe\n");
    }
}
