package players;

import game.Card;

import java.util.ArrayList;

public class Bot   {
    private ArrayList<Card> hand;

    public Bot() {
        this.hand = new ArrayList<>();
    }


    public ArrayList<Card> getHand() {
        return hand;
    }
    public void showHand() {
        System.out.println("Bot's hand:");
        for (int i = 0; i < hand.size(); i++) {
            Card c = hand.get(i);
            System.out.println(i + ": [" + c.getRank() + " " + c.getSuit() + "]");
        }
    }

}
