package interview;

/**
 * Provide a function that takes a string and returns an integer
 */
public class CalStringToIntVal {
  public int getIntegerFromString(String input) {
    if (input.matches("green|red|yellow|purple|orange|pink|turquoise|blue")) {
      return 1;
    } else if (input.length() > 9) {
      return 2;
    } else {
      return 3;
    }
  }
}
