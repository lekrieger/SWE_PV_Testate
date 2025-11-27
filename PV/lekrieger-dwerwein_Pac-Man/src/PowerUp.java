import java.awt.*;

public class PowerUp extends GameObject {
    
    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    protected void update() {
        // PowerUp-Logik hier implementieren (z.B. Kollisionserkennung mit Paku Paku)
    }       

    @Override
    protected void move() {
        // PowerUps bewegen sich nicht, daher bleibt diese Methode leer
    }
}

