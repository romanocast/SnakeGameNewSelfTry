package ch.winel.zli.game.snake;

import javax.swing.SwingUtilities;

import ch.winel.zli.game.gui.SwingGameGui;

public class SnakeGameApp {
    public static void main(String[] args) {
        // Do not ask, always do it this way
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // We need a game and a gui
                SnakeGame game = new SnakeGame();
                SwingGameGui gui = new SwingGameGui("Snake 2077");

                // Add the game to the gui ...
                gui.addGameCommandListener(game);
                gui.setGamePainter(game);

                // and the gui to the game
                game.setRedrawListener(gui);
                game.newGame();
                // Show the gui
                gui.setVisible(true);
            }
        });
    }
}
