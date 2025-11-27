import java.awt.*;

public class Ghost extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(new Color(148, 0, 211));
        
        int s = GamePanel.scale; 
        g.fillRect(x * s + s/10, y * s + s/10, s * 4/5, s * 4/5);
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
