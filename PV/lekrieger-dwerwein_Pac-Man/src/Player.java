import java.awt.*;

public class Player extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        int s = GamePanel.scale; 
        g.fillRect(x * s, y * s, s, s);
    }

    @Override
    protected void update() {
        // Player-Logik hier implementieren (Bewegung, Kollisionen, etc.)
    }   

    @Override
    protected void move() {
        // Bewegungslogik für den Player hier implementieren
    }
}
