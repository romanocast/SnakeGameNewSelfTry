package ch.winel.zli.game;

import javax.swing.JPanel;

import java.awt.Color;
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

    public void incrementLevelPoints(){
        this.levelPoints++;
    }

    public void resetLevelPoints(){
        this.levelPoints = 0;
    }

    public int getLevelPoints(){
        return levelPoints;
    }

    public void incrementGamePoints(){
        this.gamePoints++;
    }
    
    public void resetGamePoints(){
        this.gamePoints = 0;
    }

    public void resetLevel(){
        this.levelNumber = 1;
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

    @Override
    public void drawStatus(JPanel panel, Graphics2D g) {
        g.setColor(Color.red);
        g.drawString(gamePaused ? "Game paused" : "Game running", 20, 20);
        g.drawString(gameOver ? "Game over" : "", 20, 40);
        g.setColor(Color.BLACK);
        g.drawString("Level points: " + levelPoints, 20, 50);
        g.drawString("Game points: " + gamePoints, 20, 65);
        g.drawString("Level: " + levelNumber, 20, 80);
        g.setColor(Color.GRAY);
        g.drawString("Press N for restart", 20, 160);
        g.drawString("Press P for pause" , 20, 175);
        g.drawString("Press q to exit game" , 20, 190);
    }

}
