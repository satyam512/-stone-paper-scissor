import org.games.Game;
import org.games.Move;
import org.junit.Assert;
import org.junit.Test;

public class ruleTest {

    private Game game = new Game();

    @Test
    public void stoneVsPaper() {
        boolean result = game.isPlayer1Win(Move.STONE, Move.PAPER);
        Assert.assertEquals(result, Boolean.FALSE);
    }
    @Test
    public void stoneVsScissors() {
        boolean result = game.isPlayer1Win(Move.STONE, Move.SCISSORS);
        Assert.assertEquals(result, Boolean.TRUE);
    }
    @Test
    public void paperVsStone() {
        boolean result = game.isPlayer1Win(Move.PAPER, Move.STONE);
        Assert.assertEquals(result, Boolean.TRUE);
    }
    @Test
    public void paperVsScissors() {
        boolean result = game.isPlayer1Win(Move.PAPER, Move.SCISSORS);
        Assert.assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void scissorsVsStone() {
        boolean result = game.isPlayer1Win(Move.SCISSORS, Move.STONE);
        Assert.assertEquals(result, Boolean.FALSE);
    }
    @Test
    public void scissorsVsPaper() {
        boolean result = game.isPlayer1Win(Move.SCISSORS, Move.PAPER);
        Assert.assertEquals(result, Boolean.TRUE);
    }
}
