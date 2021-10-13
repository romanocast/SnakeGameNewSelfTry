package ch.winel.zli.game.snake_game.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import ch.winel.zli.game.snake_game.classes.*;

public class LevelTest {

    private Snake snake = new Snake();
    private Obstacles oblstacles = new Obstacles(12, 12);
    private Desert desert = new Desert(12, 12);
    private Level level = new Level(snake, desert, oblstacles);
    
    @Test
    public void testingGettingLevelObjects(){
        assertEquals(snake.getClass(), level.getSnake().getClass());
        assertEquals(oblstacles.getClass(), level.getObstacles().getClass());
        assertEquals(desert.getClass(), level.getDesert().getClass());
    }
}
