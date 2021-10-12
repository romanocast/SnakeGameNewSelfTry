package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Graphics2D;

public class Obstacles {
    private static final Random rnd = new Random();
    private ArrayList<Position> obstaclesPositions = new ArrayList<>();
    private static ArrayList<Color> foodColors = new ArrayList<>( Arrays.asList(
        Color.RED, Color.ORANGE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.PINK, Color.WHITE
    ));
    private Color color;

    public Obstacles(int maxX, int maxY) {
        for(int i = 0; i < maxX; i++) {
            this.obstaclesPositions.add(new Position(0, i));
            this.obstaclesPositions.add(new Position(maxX-1, i));
            this.obstaclesPositions.add(new Position(i, 0));
            this.obstaclesPositions.add(new Position(i, maxY-1));
        }
        this.obstaclesPositions.add(new Position(maxX-1, maxY-1));
        color = foodColors.get(rnd.nextInt(foodColors.size()));
    }

    public boolean intersectsWith(Position positionToCheck) {
        return obstaclesPositions.contains(positionToCheck);
    }

    public void draw(int dx, int dy, Graphics2D g) {
        g.setColor(color);
        for(Position obstacle: obstaclesPositions) {
            g.fillRect(dx * obstacle.xPosition , dy * obstacle.yPosition , dx/2, dy/2);;
        }
    }
    
}
