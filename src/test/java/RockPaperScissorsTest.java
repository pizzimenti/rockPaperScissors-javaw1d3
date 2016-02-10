import org.junit.*;
import static org.junit.Assert.*;

public class RockPaperScissorsTest {
  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_paperbeatScissors_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Paper", "Scissors"));
  }

  @Test
  public void checkWinner_rockbeatPaper_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Rock", "Paper"));
  }

}
