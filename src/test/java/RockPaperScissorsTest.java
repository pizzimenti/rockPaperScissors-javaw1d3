import org.junit.*;
import static org.junit.Assert.*;

public class RockPaperScissorsTest {
  @Test
  public void checkWinner_rockBeatsScissors_string() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("player one wins", testRockPaperScissors.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_scissorsBeatsPaper_string() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("player one wins", testRockPaperScissors.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_paperBeatsRock_string() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("player one wins", testRockPaperScissors.checkWinner("Paper", "Rock"));
  }

  @Test
  public void checkWinner_playerWinCheck_string() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("player two wins", testRockPaperScissors.checkWinner("Scissors", "Rock"));
  }

  @Test
  public void checkWinner_tie_string() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("players tie", testRockPaperScissors.checkWinner("Scissors", "Scissors"));
  }
}
