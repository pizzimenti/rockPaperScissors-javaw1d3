import java.io.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaperScissors {
  public static void main( String[] args ) {}

  public static boolean checkWinner(String play1,String play2) {
    if (play1.equalsIgnoreCase("rock") && play2.equalsIgnoreCase("scissors")){
      return true;
    } else if (play1.equalsIgnoreCase("paper") && play2.equalsIgnoreCase("scissors")){
      return true;
    } else if (play1.equalsIgnoreCase("rock") && play2.equalsIgnoreCase("paper")) {
      return true;
    }
      return false;
  }
}
