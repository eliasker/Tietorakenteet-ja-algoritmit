package postfix;

public class Main {
  public static void main(String[] args) {
    String[] input1 = {"1", "2", "+"}; 
    test(input1); // output 3.0
    String[] input2 = {"52", "2", "-"}; 
    test(input2); // output -50.0
    String[] input3 = {"3", "4", "*", "3", "+"};
    test(input3); // output 15.0
    String[] input4 = {"3", "4", "5", "*", "-"};
    test(input4); // output -17
    String[] input5 = {"3", "4", "+", "5", "2", "/", "*"};
    test(input5); // output 17.5
  }

  public static void test(String input[]) {
    PostfixCalculator calc = new PostfixCalculator();
    System.out.println(calc.calculate(input));
  }
}