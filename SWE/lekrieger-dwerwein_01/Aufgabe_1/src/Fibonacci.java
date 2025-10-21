public class Fibonacci {


    public static void fib(int n) {
        // wenn ungültige Eingabe
        if (n < 0) {
            System.out.println("Die Eingabe darf nicht negativ sein.");
            return;
        }

        // Die ersten beiden Zahlen der Folge
        long a = 0; // f_0
        long b = 1; // f_1

        System.out.println(" Fibonacci-Folge bis n = " + n + ":");

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print(a + " ");
            } else if (i == 1) {
                System.out.print(b + " ");
            } else {
                // Berechne die nächste Zahl als Summe der beiden vorherigen
                long naechste = a + b;
                System.out.print(naechste + " ");

                // Werte für die nächste Iteration
                a = b;
                b = naechste;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Aufruf
        fib(50);}
}