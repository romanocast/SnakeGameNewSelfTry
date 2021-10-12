package ch.winel.zli.game.snake_game.classes;

public class Position {
    
    final int xPosition;
    final int yPosition;

    public Position(int x, int y) {
        xPosition = x;
        yPosition = y;
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Position)
        {
            Position p = (Position) o;
            if (p.xPosition == xPosition && p.yPosition == yPosition){
                return true;
            }
        }
        return false;
    }
}
