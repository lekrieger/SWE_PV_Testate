public abstract class MobileRobot {

    protected double positionX;
    protected double positionY;
    protected double positionZ;

    public abstract void bringup();

    //Konstruktor
    public MobileRobot(double x, double y, double z) {
        this.positionX = x;
        this.positionY = y;
        this.positionZ = z;
    }



}
