package ch.winel.zli.game.snake_game.classes;
import ch.winel.zli.game.snake.SnakeGame;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;


public class SnakeGameLogic {
    
    private SnakeGame snakeGame;
    private Level level;
    private Timer timer;
    private Random random;

    public SnakeGameLogic(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        level = new Level(new Snake(), new Desert(12, 12), new Food(), new Obstacles());
        //goOn();
        initAfterLevelChanged();
    }

    private void processTick(){
        Position headPos = level.getSnake().getHeadPosition();
        Direction snakeDirection = level.getSnake().getDirection();
        Position next = level.getDesert().getNextPosition(snakeDirection, headPos);
        level.getSnake().MoveTo(next);
        headPos = next;
        if(level.getFood().intersectsWith(headPos)){
            level.getSnake().eat(level.getFood());
            respawnFood();

        }
        if(level.getObstacles().intersectsWith(headPos) || level.getSnake().selfColission()){
            snakeGame.quitGame();
        }
        snakeGame.gameNeedsRedraw();
    }

    public void changeDirection(Direction direction){
        level.getSnake().setDirection(direction);
    }

    private void respawnFood(){
        Position newFoodPos = null;
        boolean freePosition = false;
        random = new Random();
        while(!freePosition){
            newFoodPos = new Position(random.nextInt(11), random.nextInt(11));
            while(newFoodPos.getX() == 0 ){
                newFoodPos = new Position(random.nextInt(11), random.nextInt(11));
            }
            while(newFoodPos.getY() == 0 ){
                newFoodPos = new Position(random.nextInt(11), random.nextInt(11));
            }
            if(!level.getSnake().intersectsWith(newFoodPos)){
                freePosition = true;
            }
        }
        level.getFood().setPosition(newFoodPos);
    }

    public void drawGame(JPanel panel, Graphics2D g) {
        level.getSnake().draw(panel, g);
        level.getFood().draw(panel, g);
        level.getObstacles().draw(panel, g);
    }

    public void pause(){
        this.timer.cancel();
    }

    public void initAfterLevelChanged() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                processTick();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 2, 200);
    }   
}
