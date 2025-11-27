import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;    


    // abstrakte Methoden für alle GameObjects, müssen zwingend implementiert werden

    protected abstract void draw(Graphics g); //Grpahics (von java.awt.) g wird übergeben, damit jedes GameObject sich selbst zeichnen kann

    protected abstract void update() throws GameOverException;

    public Point getPosition() {
        return new Point(x, y);
    }

}