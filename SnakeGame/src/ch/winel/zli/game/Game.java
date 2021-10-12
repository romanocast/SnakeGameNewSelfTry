package ch.winel.zli.game;

import javax.swing.JPanel;
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

    public int getGamePoints(){
        return gamePoints;
    }

    public void resetGamePoints(){
        this.gamePoints = 0;
    }

    public void incrementGamePoints(){
        this.gamePoints++;
    }

    public void setRedrawListener(RedrawListener redrawListener) {
        this.redrawListener = redrawListener;
    }

    public void gameNeedsRedraw() {
        if (redrawListener != null) {
            redrawListener.gameNeedsRedraw();
        }
    }

    @Override
    public void drawStatus(JPanel panel, Graphics2D g) {
        g.drawString(
            gamePaused ? "Game Paused" : "Game Running", 20, 20);
        g.drawString("Level Points: " + levelPoints, 20, 45);
        g.drawString("Game Points: " + gamePoints, 20, 65);
        g.drawString("Level: " + levelNumber, 20, 95);
    }

}
