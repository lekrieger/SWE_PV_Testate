import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;    


    // abstrakte Methoden für alle GameObjects, müssen zwingend implementiert werden

    protected abstract void move();

    protected abstract void draw(java.awt.Graphics g); //Grpahics g wird übergeben, damit jedes GameObject sich selbst zeichnen kann

    protected abstract void update();

    public Point getPosition() {
        return new Point(x, y);
    }

}
