package ch.winel.zli.game;

import ch.winel.zli.game.gui.GameCmdListener;
import ch.winel.zli.game.gui.GamePainter;
import ch.winel.zli.game.gui.RedrawListener;

public abstract class Game implements GameCmdListener, GamePainter {
    private RedrawListener redrawListener;

    public void setRedrawListener(RedrawListener redrawListener) {
        this.redrawListener = redrawListener;
    }

    public void gameNeedsRedraw() {
        if (redrawListener != null) {
            redrawListener.gameNeedsRedraw();
        }
    }
}
