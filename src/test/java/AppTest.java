import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Rock Paper Scissors Game");
  }

  @Test
  public void playerTwoWinTest() {
    goTo("http://localhost:4567/game");
    fill("#playerOne").with("scissors");
    fill("#playerTwo").with("rock");
    submit(".btn");
    assertThat(pageSource()).contains("player two wins");
  }

  @Test
  public void tieTest() {
    goTo("http://localhost:4567/game");
    fill("#playerOne").with("scissors");
    fill("#playerTwo").with("scissors");
    submit(".btn");
    assertThat(pageSource()).contains("players tie");
  }

  @Test
  public void playerOneWinTest() {
    goTo("http://localhost:4567/game");
    fill("#playerOne").with("scissors");
    fill("#playerTwo").with("paper");
    submit(".btn");
    assertThat(pageSource()).contains("player one wins");
  }

  @Test
  public void NoValidInputTest() {
    goTo("http://localhost:4567/game");
    fill("#playerOne").with("house");
    fill("#playerTwo").with("paper");
    submit(".btn");
    assertThat(pageSource()).contains("user input not valid");
  }


}
