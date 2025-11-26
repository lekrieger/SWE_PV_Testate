import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;    


    // Methoden für alle GameObjects

    protected abstract void move();

    protected abstract void draw(java.awt.Graphics g);

    protected abstract void update();

    public Point getPosition() {
        return new Point(x, y);
    }

}
