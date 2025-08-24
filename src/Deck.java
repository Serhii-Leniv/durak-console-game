import components.Rank;
import components.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public ArrayList<Card> deckGenerator() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public Suit determineTrump() {
        Card lastCard = deck.get(deck.size() - 1); // остання карта
        return lastCard.getSuit();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
