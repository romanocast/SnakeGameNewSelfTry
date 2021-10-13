package ch.winel.zli.game.snake_game.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import ch.winel.zli.game.snake_game.classes.Position;

public class PositionTest {

    private Position position = new Position(5, 5);

    @Test
    public void testingCoordinates(){
        assertEquals(position.getX(), 5);
        assertEquals(position.getY(), 5);
    }
    
}
