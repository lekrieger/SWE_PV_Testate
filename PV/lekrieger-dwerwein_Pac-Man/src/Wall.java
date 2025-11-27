import java.awt.*;

public class Wall extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        int s = GamePanel.scale; 
        g.fillRect(x * s, y * s, s, s);
    }

    @Override
    protected void update() throws GameOverException {
        // Wände haben keine Update-Logik
    }   

}
