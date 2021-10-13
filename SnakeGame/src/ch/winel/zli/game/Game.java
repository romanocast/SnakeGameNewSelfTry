package ch.winel.zli.game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


import ch.winel.zli.game.gui.GameCmdListener;
import ch.winel.zli.game.gui.GamePainter;
import ch.winel.zli.game.gui.RedrawListener;

public abstract class Game implements GameCmdListener, GamePainter {
    private RedrawListener redrawListener;
    private boolean gameOver;
    private boolean gamePaused;
    private int levelNumber = 1;
    private int levelPoints;
    private int gamePoints;
    
    public boolean getPaused() {
        return gamePaused;
    }

    public void togglePaused() {
        gamePaused = !gamePaused;
    }

    public void setPaused(boolean paused){
        gamePaused = paused;
    }

    public void incrementPoints(){
        this.levelPoints++;
        this.gamePoints++;
    }

    public int getLevelPoints(){
        return levelPoints;
    }

    public void increaseLevel() {
        this.levelPoints = 0;
        this.levelNumber++;
    }

    public void setRedrawListener(RedrawListener redrawListener) {
        this.redrawListener = redrawListener;
    }

    public void gameNeedsRedraw() {
        if (redrawListener != null) {
            redrawListener.gameNeedsRedraw();
        }
    }

    public void setGameOver(){
        this.gameOver = true;
    }

    public void resetStatus(){
        this.levelPoints = 0;
        this.gamePoints = 0;
        this.levelNumber = 1;
    }

    @Override
    public void drawStatus(JPanel panel, Graphics2D g) {
        int fontSize = panel.getHeight()/ 20;
        g.setFont(new Font("scheissegal", 1, fontSize)); 
        g.drawString("", 20, 20 + fontSize);
        g.setColor(Color.red);
        if(!gameOver){
            g.drawString(gamePaused ? "Game paused" : "Game running", 20, 20 +3 *fontSize);
        }
        g.drawString(gameOver ? "Game over" : "", 20, 20 +5 *fontSize);
        g.setColor(Color.BLACK);
        g.drawString("Level points: " + levelPoints, 20, 20 +7 *fontSize);
        g.drawString("Game points: " + gamePoints, 20, 20 +9 *fontSize);
        g.drawString("Level: " + levelNumber, 20, 20 +11 *fontSize);
        g.setColor(Color.GRAY);
        g.drawString("Press N for restart", 20, 20+13 *fontSize);
        g.drawString("Press P for pause" , 20, 20+15 *fontSize);
        g.drawString("Press q to exit game" , 20, 20+17 *fontSize);
    }

}
