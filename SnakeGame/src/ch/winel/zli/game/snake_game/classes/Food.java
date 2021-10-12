package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Food {
    private static final Random rnd = new Random();
    private static ArrayList<Color> foodColors = new ArrayList<>( Arrays.asList(
        Color.RED, Color.ORANGE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.PINK, Color.WHITE
    ));

    private Position position;
    private Color color;
     
   
    public Food(Position pos) {
        position = pos;
        color = foodColors.get(rnd.nextInt(foodColors.size()));
     }

    public Boolean intersectsWith(Position otherPosition){
        return (position.equals(otherPosition));
        //return (position.xPosition == otherPosition.xPosition  && position.yPosition == otherPosition.yPosition);
    }

    public void draw(int dx, int dy, Graphics2D g) {
        g.setColor(color);
        g.fillRect(dx * position.getX() , dy * position.getY() , dx/2, dy/2);
    }
}
