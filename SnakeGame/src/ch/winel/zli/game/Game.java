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
    private int levelNumber;
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
    }

}
