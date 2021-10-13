package ch.winel.zli.game.snake_game.classes;

import java.util.Random;

public class Level {
    private static final Random rnd = new Random();

    private Desert desert;
    private Food food;
    private Snake snake;
    private Obstacles obstacles;

    public Level(Snake snake, Desert desert, Obstacles obstacles) {
        this.desert = desert;
        this.snake = snake;
        this.obstacles = obstacles;
        placeFood();
    }

    public void placeFood() {
        Position pos;
        do{
            pos = new Position(rnd.nextInt(desert.getWidth()), rnd.nextInt((desert.getHeight())));
        }while(obstacles.intersectsWith(pos) || snake.intersectsWith(pos));
        food =  new Food(pos);
    }

    public Food getFood() {
        return food;
    }

    public Desert getDesert() {
        return desert;
    }

    public Obstacles getObstacles() {
        return obstacles;
    }

    public Snake getSnake(){
        return snake;
    }
}
