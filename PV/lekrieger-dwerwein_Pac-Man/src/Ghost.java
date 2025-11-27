import java.awt.*;

public class Ghost extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.RED);
        
        int s = GamePanel.scale; 
        g.fillRect(x * s, y * s, s, s);
    }

    @Override
    protected void update() {
        // Geister-Logik hier implementieren (Bewegung, Kollisionen, etc.)
    }

    @Override
    protected void move() {
        // Bewegungslogik für den Geist hier implementieren
    }
}
