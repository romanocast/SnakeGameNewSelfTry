package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Obstacles {
    
    private ArrayList<Position> obstaclesPositions = new ArrayList<>();

    public Obstacles() {
        for(int i = 0; i < 12; i++) {
            this.obstaclesPositions.add(new Position(0, i));
            this.obstaclesPositions.add(new Position(12, i));
            this.obstaclesPositions.add(new Position(i, 0));
            this.obstaclesPositions.add(new Position(i, 12));
        }
        this.obstaclesPositions.add(new Position(12, 12));
    }

    public boolean intersectsWith(Position positionToCheck) {
        return obstaclesPositions.contains(positionToCheck);
    }

    public void draw(JPanel panel, Graphics2D g) {
        g.setColor(Color.ORANGE);
        for(Position obstacle: obstaclesPositions) {
            g.fillRect(obstacle.getX() * 20 + 5, obstacle.getY() *20 + 5, 10, 10);;
        }
    }
    
}
