import java.awt.*;

public class Dot extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x+8, y+8, 4, 4);
    }

    @Override
    protected void update() {
        // Dot-Logik hier implementieren (z.B. Kollisionserkennung mit Paku Paku)
    }       

    @Override
    protected void move() {
        // Dots bewegen sich nicht, daher bleibt diese Methode leer
    }
}
