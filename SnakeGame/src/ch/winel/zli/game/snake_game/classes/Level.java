package ch.winel.zli.game.snake_game.classes;

public class Level {
    
    private Desert desert;
    private Food food;
    private Snake snake;
    private Obstacles obstacles;

    public Level(Snake snake, Desert desert, Food food, Obstacles obstacles) {
        this.desert = desert;
        this.food = food;
        this.snake = snake;
        this.obstacles = obstacles;
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
