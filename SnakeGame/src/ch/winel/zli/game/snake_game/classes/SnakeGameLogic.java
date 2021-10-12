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
        Desert desert = new Desert(12, 12);
        level = new Level(new Snake(), desert,new Obstacles(desert.getWidth(), desert.getHeight()));
        initAfterLevelChanged();
    }

    private void processTick(){
        if(snakeGame.getPaused()){
        }
        Position headPos = level.getSnake().getHeadPosition();
        Direction snakeDirection = level.getSnake().getDirection();
        Position next = level.getDesert().getNextPosition(snakeDirection, headPos);
        level.getSnake().MoveTo(next);
        headPos = next;
        if(level.getFood().intersectsWith(headPos)){
            level.getSnake().eat(level.getFood());
            level.placeFood();

        }
        if(level.getObstacles().intersectsWith(headPos) || level.getSnake().selfColission()){
            snakeGame.setPaused(true);
        }
        snakeGame.gameNeedsRedraw();
    
    }

    
    public void changeDirection(Direction direction){
        snakeGame.setPaused(false);
        level.getSnake().setDirection(direction);
    }

    public void drawGame(JPanel panel, Graphics2D g) {
        int dx = panel.getWidth()/level.getDesert().getWidth();
        int dy = panel.getHeight()/level.getDesert().getHeight();
        System.out.println(dx);
        System.out.println(panel.getWidth());
        System.out.println( level.getDesert().getWidth());
        level.getSnake().draw(dx, dy, g);
        level.getFood().draw(dx, dy, g);
        level.getObstacles().draw(dx, dy, g);
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
