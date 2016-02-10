import java.io.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

  public static String checkWinner(String play1,String play2) {
    HashMap<String, String> winScenerios = new HashMap<String, String>();
    String[] combos = {"rock", "scissors", "paper", "rock", "paper", "scissors", "rock", "paper", "scissors"};
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
    return "true";
  }
// public class RockPaperScissors {
//   public static void main( String[] args ) {}
//
//   public static String checkWinner(String play1,String play2) {
//     HashMap<String, String> winScenerios = new HashMap<String, String>();
//     String[] combos = {"rock", "scissors", "paper", "rock", "paper", "scissors", "rock"};
//     for (int i = 0; i < 6; i++) {
//       String playOne = combos[i];
//       String playTwo = combos[i+1];
//       String combo = playOne.concat(playTwo);
//       if (i < 3) {
//         winScenerios.put(combo,"player one wins");
//       } else {
//         winScenerios.put(combo,"player two wins");
//       }
//     }
//     play1 = play1.toLowerCase();
//     play2 = play2.toLowerCase();
//     String userCombo = play1.concat(play2);
//     return winScenerios.get(userCombo);
//     // return "Player one and two threw the same sign";
//   }
}
