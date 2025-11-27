import java.awt.*;

public class Dot extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.WHITE);
        int s = GamePanel.scale; 
        g.fillRect(x * s, y * s, s, s);
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
