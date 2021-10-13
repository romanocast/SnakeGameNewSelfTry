package ch.winel.zli.game.snake_game.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.winel.zli.game.snake_game.classes.*;

public class DesertTest {
    
    private Desert desert = new Desert(12,12);

    @Test
    public void testingDimensions(){
        assertTrue(desert.getWidth() == 12 && desert.getHeight() == 12);
    }

    @Test
    public void testingNextPosition(){
        assertEquals(new Position(2, 2), desert.getNextPosition(Direction.RIGHT, new Position(1, 2)));
    }
}
