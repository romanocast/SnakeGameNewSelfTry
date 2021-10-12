package ch.winel.zli.game.snake_game.classes;

public class Desert {
   
    private int height;
    private int width;

    public Desert(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Position getNextPosition(Direction snakeDirection, Position headPos){
        switch (snakeDirection){
            case UP:
                return new Position(headPos.getX(), headPos.getY() - 1);
            case DOWN:
                return new Position(headPos.getX(), headPos.getY() + 1);
            case LEFT:
                return new Position(headPos.getX() - 1, headPos.getY());
            case RIGHT:
                return new Position(headPos.getX() + 1, headPos.getY());
            default:
                return headPos;
        }
    }
}
