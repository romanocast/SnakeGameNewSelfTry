package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Obstacles {
    
    private ArrayList<Position> obstaclesPositions = new ArrayList<>();

    public Obstacles(int maxX, int maxY) {
        for(int i = 0; i < maxX; i++) {
            this.obstaclesPositions.add(new Position(0, i));
            this.obstaclesPositions.add(new Position(maxX-1, i));
            this.obstaclesPositions.add(new Position(i, 0));
            this.obstaclesPositions.add(new Position(i, maxY-1));
        }
        this.obstaclesPositions.add(new Position(maxX-1, maxY-1));
    }

    public boolean intersectsWith(Position positionToCheck) {
        return obstaclesPositions.contains(positionToCheck);
    }

    public void draw(int dx, int dy, Graphics2D g) {
        g.setColor(Color.ORANGE);
        for(Position obstacle: obstaclesPositions) {
            g.fillRect(dx * obstacle.xPosition , dy * obstacle.yPosition , dx, dy);;
        }
    }
    
}
