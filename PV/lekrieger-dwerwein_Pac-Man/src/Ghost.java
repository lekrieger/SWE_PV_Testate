import java.awt.*;

public class Ghost extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x+1, y+1, 18, 18);
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
