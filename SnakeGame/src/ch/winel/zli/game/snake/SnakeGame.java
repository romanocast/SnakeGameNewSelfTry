package ch.winel.zli.game.snake;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.winel.zli.game.Game;
import ch.winel.zli.game.snake_game.classes.Direction;
import ch.winel.zli.game.snake_game.classes.SnakeGameLogic;

public class SnakeGame extends Game {
    
    private SnakeGameLogic gameLogic;

   
    @Override
    public void newGame() {
        gameLogic = new SnakeGameLogic(this);   
        setPaused(true);
        resetStatus();
        gameNeedsRedraw();   
    }

    @Override
    public void quitGame() {
        System.out.println("quitGame");
        System.exit(0);;
    }

    @Override
    public void pauseGame() {
        togglePaused();
        gameNeedsRedraw();
    }

    @Override
    public void goUp() {
        gameLogic.changeDirection(Direction.UP);
    }

    @Override
    public void goDown() {
        gameLogic.changeDirection(Direction.DOWN);
    }

    @Override
    public void goLeft() {
        gameLogic.changeDirection(Direction.LEFT);
    }

    @Override
    public void goRight() {
        gameLogic.changeDirection(Direction.RIGHT);
    }

    @Override
    public void drawScene(JPanel panel, Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        gameLogic.drawGame(panel, g);
        g.setColor(Color.BLACK);
    }
}
