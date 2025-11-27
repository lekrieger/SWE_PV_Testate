import java.awt.*;

public class PowerUp extends GameObject {
    
    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.BLUE);
        int s = GamePanel.scale; 
        g.fillRect(x * s + s/10, y * s + s/10, s * 4/5, s * 4/5);
    }

    @Override
    protected void update() throws GameOverException {
        // PowerUp-Logik hier implementieren (z.B. Kollisionserkennung mit Paku Paku)
    }       

}

