package ch.winel.zli.game.snake_game.classes;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Snake {
    
    private ArrayList<Position> body;
    private Direction direction;
    private boolean eats;
    private Direction lastDirection;
    
    public Snake() {
        eats = false;
        direction = Direction.RIGHT;
        body = new ArrayList<Position>(){
            {
                add(new Position(4, 2));
                add(new Position(4, 2));
                add(new Position(4, 3));
            }
        };
    }

    public void MoveTo(Position next) {
        body.add(0, next);
        lastDirection = direction;
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
        g.setColor(Color.GREEN);
        for (Position position : body) {
            if(!position.equals(body.get(0))){
                g.fillRect(dx * position.getX() , dy * position.getY() , dx, dy);
            }
        }
        g.setColor(Color.BLUE);
        g.fillRect(dx * body.get(0).getX() , dy * body.get(0).getY() , dx, dy);
    }
}
