public class Player extends GameObject {

    @Override
    protected void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x+1, y+1, 18, 18); //+1 um Pacman zu zentrieren
    }
}
