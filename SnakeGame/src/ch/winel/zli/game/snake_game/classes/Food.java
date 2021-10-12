package ch.winel.zli.game.snake_game.classes;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Food {

    private Position position;
    private Random random = new Random();
    private Position newPosition;
    ArrayList<Color> foodColors = new ArrayList<>( Arrays.asList(
        Color.RED, Color.ORANGE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.BLUE
    ));
    
   
    public Food() {

        newPosition = new Position(random.nextInt(11), random.nextInt(11));
        while(newPosition.getX() == 0 ){
            position = new Position(random.nextInt(11), random.nextInt(11));
        }
        while(newPosition.getY() == 0 ){
            newPosition = new Position(random.nextInt(11), random.nextInt(11));
        }
        this.position = newPosition;
    }

    public Boolean intersectsWith(Position otherPosition){
        return (position.equals(otherPosition));
        //return (position.xPosition == otherPosition.xPosition  && position.yPosition == otherPosition.yPosition);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void draw(JPanel panel, Graphics2D g) {
        Color switchColor = foodColors.get(random.nextInt(5));
        g.setColor(switchColor);
        g.fillRect(position.getX() * 20, position.getY() * 20, 10, 10);
    }
}
