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
    
    public void draw(JPanel panel, Graphics2D g) {
        g.setColor(Color.GREEN);
        for (Position position : body) {
            if(!position.equals(body.get(0))){
                g.fillRect(position.getX() * 20 , position.getY() * 20 , 10, 10);
            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(body.get(0).getX() * 20 , body.get(0).getY() * 20 , 20, 20);

       // for(int i = 0; i < body.size() - 1; i++){
         //   g.fillRect(body.get(i).getX() * 10 , body.get(i).getY() * 10 , 10, 10);
        //}

        //g.setColor(Color.BLUE);
        //{
          //  g.fillRect(body.get(2).getX() * 10 , body.get(2).getY() * 10 , 10, 10);
        //}
    }
}
