import java.awt.*;

public class Dot extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.RED);
        int s = GamePanel.scale; 
        g.fillOval(x * s + s/2 - s/8, y * s + s/2 - s/8, s/4, s/4);
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
