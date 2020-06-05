package cardgame;

import cardgame.Card.Suit;
import cardgame.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 * This class +++Insert Description Here+++
 *
 * @author Paul Bonenfant
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Card[] cardHand = new Card[20];
        Random random = new Random();

        for (int i = 0; i < cardHand.length; i++) {

            Value value = Card.Value.values()[
                    random.nextInt(Card.Value.values().length)];

            Suit suit = Card.Suit.values()[
                    random.nextInt(Card.Suit.values().length)];

            Card card = new Card(value, suit);

            cardHand[i] = card;
        }
       
        System.out.println("Here are the cards");

        for (Card card : cardHand) {
            System.out.printf("%s of %s\n",
                    card.getValue(), card.getSuit());
        }
        
        System.out.println("\nChoose a suit:");
        for (int i = 0; i < Card.Suit.values().length; i++) {

            System.out.println((i + 1) + ": " + 
                    Card.Suit.values()[i]);

        }
        
        int suit = input.nextInt() - 1;

        System.out.println("Please choose the value");
        
        for (int i = 0; i < Card.Value.values().length; i++) {
            System.out.println((i + 1) + ": " +
                    Card.Value.values()[i]);
        
        }
        
        int value = input.nextInt() - 1;

        Card userGuess = new Card(
            Card.Value.values()[value],
            Card.Suit.values()[suit]);
        
        boolean match = false;
        
        for (Card card: cardHand) {
        
            if (card.getValue() == userGuess.getValue() &&
                    card.getSuit() == userGuess.getSuit()) {
            
                match = true;
                break;
            }
        
        }
        
        System.out.println("You got a match: " + match);
    }
}
