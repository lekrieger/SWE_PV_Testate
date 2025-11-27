import java.awt.*;

public class Dot extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.RED);
        int s = GamePanel.scale; 
        g.fillOval(x * s + s/2 - s/8, y * s + s/2 - s/8, s/4, s/4);
    }

    @Override
    protected void update() throws GameOverException{
        // Dots haben keine Update-Logik
    }       

}
