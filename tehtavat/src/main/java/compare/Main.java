package compare;

import java.util.*;

/**
 * @author kamaj
 */

public class Main {
  public static void main(String[] args) {
    ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
    RandomString rString = new RandomString(10);
    float genBalance;
    TrafficCard myCard;
    Random r = new Random();
    int i;
    for (i = 0; i < 10; i++) {
      genBalance = ((float) r.nextInt(1000) / 10);
      myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
      cardUsers.add(myCard);
    }

    Iterator<TrafficCard> itr = cardUsers.iterator();
    while (itr.hasNext()) {
      TrafficCard curr = itr.next();
      System.out.println(curr + "comparing to: " +  cardUsers.get(0) + " compareTo: " + curr.compareTo(cardUsers.get(1)));
    }
  }
}