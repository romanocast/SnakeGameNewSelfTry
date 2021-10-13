package ch.winel.zli.game.snake_game.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import ch.winel.zli.game.snake_game.classes.*;

public class SnakeTest {

    private Position position = new Position(5, 5);
    private Food food = new Food(position);
    private Snake snake = new Snake();
    
    @Test
    public void testingFoodIntersection() {
        assertTrue(food.intersectsWith(new Position(5, 5)));
    }

    @Test
    public void testingFoodNotIntersection() {
        assertFalse(food.intersectsWith(new Position(5, 7)));
    }

    @Test
    public void testingFoodEating() {
      
    }
}
