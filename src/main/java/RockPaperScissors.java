import java.io.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/game", (request, response) -> {
      Map<String, String> model = new HashMap<String, String>();
      model.put("template", "templates/game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      Map<String, String> model = new HashMap<String, String>();
      model.put("template", "templates/result.vtl");
      String player1 = request.queryParams("player1");
      String player2 = request.queryParams("player2");
      model.put("player1", player1);
      model.put("player2", player2);
      String result = checkWinner(player1, player2);
      model.put("result", result);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String checkWinner(String play1,String play2) {
    HashMap<String, String> winScenerios = new HashMap<String, String>();
    String[] combos = {"rock", "scissors", "paper", "rock", "paper", "scissors", "rock", "paper", "scissors", "house"};
    for (int i = 0; i < 9; i++) {
      String playOne = combos[i];
      String playTwo = combos[i+1];
      String tie = playOne.concat(playOne);
      String combo = playOne.concat(playTwo);
      if (i < 3) {
        winScenerios.put(combo,"player one wins");
      } else if (i < 7) {
        winScenerios.put(combo,"player two wins");
      } else {
        winScenerios.put(tie,"players tie");
      }
    }

    play1 = play1.toLowerCase();
    play2 = play2.toLowerCase();
    String userCombo = play1.concat(play2);
    String winScenerioString = winScenerios.get(userCombo);
    if (winScenerioString == null) {
        winScenerioString = "user input not valid";
      }
    return winScenerioString;
  }
}
