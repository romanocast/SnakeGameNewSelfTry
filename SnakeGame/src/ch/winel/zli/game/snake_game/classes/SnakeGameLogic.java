package ch.winel.zli.game.snake_game.classes;
import ch.winel.zli.game.snake.SnakeGame;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;


public class SnakeGameLogic {
    
    private SnakeGame snakeGame;
    private Level level;
    private Timer timer;
    private int speed = 400;
    //Change the Steps to set the points to reach for the next level
    private int nextLevelSteps = 3;

    

    public SnakeGameLogic(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        Desert desert = new Desert(12, 12);
        level = new Level(new Snake(), desert,new Obstacles(desert.getWidth(), desert.getHeight()));
        initAfterLevelChanged();
    }

    private void processTick(){

        //If the game status is paused don't tick
        if(snakeGame.getPaused()){
            return;
        }

        //Get the direction the snake moves. The actual head position and the next Position the snake will move to.
        Direction snakeDirection = level.getSnake().getDirection();
        Position headPos = level.getSnake().getHeadPosition();
        Position next = level.getDesert().getNextPosition(snakeDirection, headPos);

        //Tell the snake to move to the next direction we just got.
        level.getSnake().MoveTo(next);

        //On the next tick the new head Position will be the actual head pos
        headPos = next;

        //If the snake eats food. (head position same as food position)
        if(level.getFood().intersectsWith(headPos)){

            //Trigger the eat() Function from the snake to true which will not remove (so adding) a body part from the snake on the next process tick.
            level.getSnake().eat(level.getFood());

            //Let the level spawn a new food on the playfield which is not occupied by the snake or a obstacle
            level.placeFood();

            //Increment gamePoints and levelPoints
            snakeGame.incrementPoints();
            if(snakeGame.getLevelPoints() == nextLevelSteps){

                /*When the player reaches a certain level (change nextLevelSteps of the snakeGameLogic class to decide the steps)
                  the increaseLevel function gets triggered, which increases the game level and restets the level points.
                */
                snakeGame.increaseLevel();

                //Cause the gamespeed gets changed we cancel the timer to proivide issues.
                timer.cancel();

                //Set new gamespeed. The higher the number of which the speed gets divided to, the lower the speed increasement will be on the levelstep.
                this.speed = speed -(speed/5);

                //Start new tick.
                initAfterLevelChanged();
            }
        }

        //If the snake collides with an obstacle or with itself the game gets paused and the game over status resets the points and level.
        if(level.getObstacles().intersectsWith(headPos) || level.getSnake().selfColission()){
            snakeGame.setPaused(true);
            snakeGame.setGameOver();
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
        timer.scheduleAtFixedRate(timerTask, 2, speed);
    }   
}
