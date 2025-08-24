import java.util.ArrayList;

public class Player   {
    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void showHand() {
        System.out.println("Player's hand:");
        for (int i = 0; i < hand.size(); i++) {
            Card c = hand.get(i);
            System.out.println(i + ": [" + c.getRank() + " " + c.getSuit() + "]");
        }
    }



}