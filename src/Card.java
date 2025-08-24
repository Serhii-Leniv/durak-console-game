import components.Rank;
import components.Suit;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean canBeat(Card other, Suit trump) {
        // 1. Якщо ця карта козир, а інша ні — б'є
        if (this.suit == trump && other.suit != trump) return true;
        // 2. Якщо ця карта не козир, а інша козир — не б'є
        if (this.suit != trump && other.suit == trump) return false;
        // 3. Якщо обидві карти однієї масті — порівнюємо ранг
        if (this.suit == other.suit) return this.rank.getValue() > other.rank.getValue();
        // 4. Інші випадки — не б'є
        return false;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
