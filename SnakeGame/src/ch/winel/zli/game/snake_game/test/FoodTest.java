package ch.winel.zli.game.snake_game.test;

import org.junit.jupiter.api.Test;

import ch.winel.zli.game.snake_game.classes.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

public class FoodTest {
    private Position position = new Position(4,2);
    private Food food = new Food(position);
    

    @Test
    public void testIntersectionTrue(){
        assertTrue(food.intersectsWith(new Position(4,2)));
    }
}
