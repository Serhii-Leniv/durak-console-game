package game;

import components.Suit;
import components.TurnResult;
import players.Bot;
import players.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Suit trumpSuit;
    private Player player;
    private Bot bot;
    private Deck deck;


    public Game(Player player, Bot bot, Deck deck, Suit trumpSuit) {
        this.player = player;
        this.bot = bot;
        this.deck = deck;
        this.trumpSuit = trumpSuit;

    }

    public void dealCardsToPlayer() {
        for (int i = player.getHand().size(); i < 6; i++) {
            ArrayList<Card> currentDeck = deck.getDeck();
            player.getHand().add(currentDeck.remove(0));
        }
        System.out.println("Карти роздані.");
    }

    public void dealCardsToBot() {
        for (int i = bot.getHand().size(); i < 6; i++) {
            ArrayList<Card> currentDeck = deck.getDeck();
            bot.getHand().add(currentDeck.remove(0));
        }
        System.out.println("Карти роздані.");
    }


    public TurnResult playerAttack() {


        player.showHand();
        System.out.println("Козир: " + trumpSuit);
        System.out.println("Виберіть карту для ходу (введіть індекс): ");
        try {


        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        Card playedCard = player.getHand().remove(index);
        System.out.println("Ви зіграли: " + playedCard.getRank() + " " + playedCard.getSuit());
        Card beatingCard = null;
        for (Card card : bot.getHand()) {
            if (card.canBeat(playedCard, trumpSuit)) {
                beatingCard = card;
                break;
            }
        }

        if (beatingCard != null) {
            bot.getHand().remove(beatingCard);
            System.out.println("Бот побив вас картою: " + beatingCard.getRank() + " " + beatingCard.getSuit());
            return TurnResult.LOSE;
        } else {
            System.out.println("Бот не може побити вашу карту і бере її.");
            bot.getHand().add(playedCard);
            return TurnResult.WIN;
        }
        } catch (Exception e) {
            System.out.println("Невірний індекс. Спробуйте ще раз.");
            return playerAttack();
        }
    }

    public TurnResult playerDefend() {
        Random random = new Random();
        int botIndex = random.nextInt(bot.getHand().size());
        Card botCard = bot.getHand().get(botIndex);


        player.showHand();
        System.out.println("Козир: " + trumpSuit);
        System.out.println("Бот атакує вас картою: " + botCard.getRank() + " " + botCard.getSuit());
        System.out.println("Виберіть карту для захисту (введіть індекс) або введіть число -1 щоб взяти карту: ");
        Scanner scanner = new Scanner(System.in);
        try {

        int index = scanner.nextInt();
            while (index < -1 || index >= player.getHand().size()) {
                System.out.println("Невірний індекс. Спробуйте ще раз.");
                index = scanner.nextInt();
            }
            if (!player.getHand().get(index).canBeat(botCard, trumpSuit)) {
            System.out.println("Ви не можете побити цю карту цією картою. Спробуйте ще раз.");
            return playerDefend();
        }
        if (index == -1) {
            player.getHand().add(botCard);
            bot.getHand().remove(botIndex);
            System.out.println("Ви взяли карту: " + botCard.getRank() + " " + botCard.getSuit());
            return TurnResult.WIN;
        }

        Card playerCard = player.getHand().get(index);
        if (index != -1 && playerCard.canBeat(botCard, trumpSuit)) {
            player.getHand().remove(index);
            System.out.println("Ви побили карту бота: " + botCard.getRank() + " " + botCard.getSuit() + " картою: " + playerCard.getRank() + " " + playerCard.getSuit());
            bot.getHand().remove(botIndex);
            return TurnResult.LOSE;
        } else
            return TurnResult.LOSE;
        } catch (Exception e) {
            System.out.println("Невірний індекс. Спробуйте ще раз.");
            return TurnResult.DRAW;
        }
    }

}





