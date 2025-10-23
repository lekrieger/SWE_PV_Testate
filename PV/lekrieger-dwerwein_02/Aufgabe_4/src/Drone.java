public class Drone extends MobileRobot implements Flyable {

    // Konstruktor
    public Drone(double x, double y, double z) {
        super(x, y, z);
    }

    // Implementierung der abstrakten Methode aus MobileRobot
    @Override
    public void bringup() {
        System.out.println("Drone starting up at (" + positionX + ", " + positionY + ", " + positionZ + ")");
    }

    // Implementierung der Methode aus Flyable
    @Override
    public void flyForward(double distance) {
        positionZ += distance;
        System.out.println("Flying forward: " + distance + " units to position Z");
    }

}
