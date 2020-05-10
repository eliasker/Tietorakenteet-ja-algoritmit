package compare;

/**
 *
 * @author kamaj
 */
public class TrafficCard implements Comparable {
  int mTravellerNumber;
  String mOwnerName;
  float mBalance;

  public TrafficCard(int tNumber, String oName, float balance) {
    mTravellerNumber = tNumber;
    mOwnerName = oName;
    mBalance = balance;
  }

  @Override
  public String toString() {
    return "owner: " + mOwnerName + " number: " + mTravellerNumber + " balance: " + mBalance;
  }

  /**
   * @author eliasker
   */
  @Override
  public int compareTo(Object o) {
    TrafficCard obj = (TrafficCard) o;
    int diff = obj.mTravellerNumber - this.mTravellerNumber;
    if (diff == 0)
      return 0;
    else if (diff > 0)
      return 1;
    else
      return -1;
  }
}
