import java.awt.*;

public class Wall extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    protected void update() {
        // Wall-Logik hier implementieren (falls nötig)
    }   

    @Override
    protected void move() {
        // Wände bewegen sich nicht, daher bleibt diese Methode leer
    }
}