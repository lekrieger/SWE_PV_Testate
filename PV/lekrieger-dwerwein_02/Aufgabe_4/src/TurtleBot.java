public class TurtleBot extends MobileRobot implements Drivable {

    // Konstruktor
    public TurtleBot(double x, double y, double z) {
        super(x, y, z);
    }

    // Implementierung der abstrakten Methode aus MobileRobot
    @Override
    public void bringup() {
        System.out.println("TurtleBot starting up at (" + positionX + ", " + positionY + ", " + positionZ + ")");
    }

    // Implementierung der Methode aus Drivable
    @Override
    public void driveForward(double distance) {
        positionZ += distance;
        System.out.println("Driving forward: " + distance + " units to position Z");
    }




}
