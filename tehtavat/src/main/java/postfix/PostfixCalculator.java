package postfix;

import java.util.ArrayList;
import java.util.Arrays;

import stack.*;
//import java.util.Stack;

public class PostfixCalculator {
  private final ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

  public String calculate(String[] input) {
    Stack stack = new Stack();

    for (String str : input) {
      if (str.trim().isEmpty())
        continue;

      if (operators.contains(str)) {
        double right = Double.parseDouble(stack.pop().getData());
        double left = Double.parseDouble(stack.pop().getData());
        double value = 0;
        switch (str) {
          case "+":
            value = left + right;
            break;
          case "-":
            value = left - right;
            break;
          case "*":
            value = left * right;
            break;
          case "/":
            value = left / right;
            break;
          default:
            break;
        }
        System.out.println("Operation: " + left + " " + str + " " + right);
        stack.push(Double.toString(value));
      } else {
        stack.push(str);
      }
    }
    return stack.pop().getData();
  }
}