import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {

    @Test
    public void whenSecondPlayerWinTest() {
        Player petya = new Player(123, "Петя", 120);
        Player vasya = new Player(1241354, "Вася", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int expected = 2;
        int actual = game.round("Вася", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerWinTest() {
        Player vasya = new Player(123, "Вася", 120);
        Player petya = new Player(1241354, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int expected = 1;
        int actual = game.round("Вася", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenStrengthEqualTest() {
        Player vasya = new Player(123, "Вася", 100);
        Player petya = new Player(1241354, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int expected = 0;
        int actual = game.round("Вася", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExistTest() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Жора", "Вася")
        );
    }

    @Test
    public void whenSecondPlayerNotExistTest() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Жора")
        );
    }
}