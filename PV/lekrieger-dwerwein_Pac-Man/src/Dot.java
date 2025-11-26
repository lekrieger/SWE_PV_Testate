import java.awt.*;

public class Dot extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 5, 5);
    }
}
