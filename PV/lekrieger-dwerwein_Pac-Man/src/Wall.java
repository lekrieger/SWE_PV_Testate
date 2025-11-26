import java.awt.*;

public class Wall extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 20, 20);
    }
}