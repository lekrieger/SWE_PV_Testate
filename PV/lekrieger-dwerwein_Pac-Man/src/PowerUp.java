import java.awt.*;

public class PowerUp extends GameObject {
    
    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.BLUE);
        int s = GamePanel.scale; 
        g.fillRect(x * s, y * s, s, s);
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

