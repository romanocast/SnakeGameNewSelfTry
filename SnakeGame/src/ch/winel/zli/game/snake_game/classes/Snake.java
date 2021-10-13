package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Graphics2D;


public class Snake {
    private static final Random rnd = new Random();
    private static ArrayList<Color> foodColors = new ArrayList<>( Arrays.asList(
        Color.RED, Color.ORANGE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.PINK, Color.WHITE
    ));
    private ArrayList<Position> body;
    private Direction direction;
    private boolean eats;
    private Direction lastDirection;
    private Color colorHead;
    private Color colorBody;
    
    public Snake() {
        eats = false;
        direction = Direction.RIGHT;
        body = new ArrayList<Position>(){
            {
                add(new Position(4, 2));
                add(new Position(4, 3));
                add(new Position(4, 4));
            }
        };
        colorHead = foodColors.get(rnd.nextInt(foodColors.size()));
        colorBody = foodColors.get(rnd.nextInt(foodColors.size()));
    }

    public void MoveTo(Position next) {
        body.add(0, next);
        if (!eats){
            body.remove(body.size() -1);
        }
        else {
            eats = false;
        }
        lastDirection = direction;
    }

    public void eat(Food food) {
        eats = true;
    }

    public Position getHeadPosition() {
        return body.get(0);
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean intersectsWith(Position toCheck) {
        return body.contains(toCheck);
    }

    public boolean selfColission(){
        for(int i = 1; i < body.size() -1; i++) {
            if(body.get(0).equals(body.get(i))){
                return true;
            }
        }
        return false;
    }

    public void setDirection(Direction direction) {
        switch(direction){
            case LEFT:
                if(lastDirection != Direction.RIGHT) {
                    this.direction = direction;
                }
                break;
            case UP:
                if(lastDirection != Direction.DOWN) {
                    this.direction = direction;
                }
                break;
            case DOWN:
                if(lastDirection != Direction.UP) {
                    this.direction = direction;
                }
                break;
            case RIGHT:
                if(lastDirection != Direction.LEFT) {
                    this.direction = direction;
                }
                break;
        }
        
    }
    
    public void draw(int dx, int dy, Graphics2D g) {
        g.setColor(colorHead);
        for (Position position : body) {
            if(!position.equals(body.get(0))){
                g.fillRect(dx * position.getX() , dy * position.getY() , dx/2, dy/2);
            }
        }
        g.setColor(colorBody);
        g.fillRect(dx * body.get(0).getX() , dy * body.get(0).getY() , dx/2, dy/2);
    }
}
