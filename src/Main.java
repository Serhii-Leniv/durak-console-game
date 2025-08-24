import components.Suit;


public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        Bot bot = new Bot();
        Deck deck = new Deck();
        deck.deckGenerator();
        Game game = new Game(player, bot, deck, deck.determineTrump());
        game.dealCardsToPlayer();
        game.dealCardsToBot();


        while (!player.getHand().isEmpty() && !bot.getHand().isEmpty() && !deck.getDeck().isEmpty()) {



            while (game.playerAttack() == components.TurnResult.WIN) {
                game.playerAttack();
            }
            game.dealCardsToPlayer();
            game.dealCardsToBot();


            while (game.playerDefend() == components.TurnResult.WIN) {
                game.playerDefend();
            }
            game.dealCardsToBot();
            game.dealCardsToPlayer();
            if (player.getHand().isEmpty() && deck.getDeck().isEmpty()){
                System.out.println("Ви виграли!");
                break;
            } else if (bot.getHand().isEmpty() && deck.getDeck().isEmpty()) {
                System.out.println("Бот виграв!");
                break;
            }

        }System.out.println("Гра завершена.");
    }
}