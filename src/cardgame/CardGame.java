package cardgame;

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

        Card[] cardHand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < cardHand.length; i++) {

            int value = random.nextInt(13) + 1;

            String suit = Card.SUITS[random.nextInt(4)];

            Card card = new Card(value, suit);

            cardHand[i] = card;
        }

        System.out.println("Here are the cards");

        for (Card card : cardHand) {
            System.out.printf("%d of %s\n",
                    card.getValue(), card.getSuit());
        }
        
        System.out.println("\nChoose a suit");
        for (int i = 0; i < Card.SUITS.length; i++) {

            System.out.println((i + 1) + ": " + Card.SUITS[i]);

        }
        int suit = input.nextInt();

        System.out.println("Enter the value (1 to 13)");
        int value = input.nextInt();

        Card userGuess = new Card(value, Card.SUITS[suit - 1]);
        
        boolean match = false;
        
        for (Card card: cardHand) {
        
            if (card.getValue() == userGuess.getValue() &&
                    card.getSuit().equals(userGuess.getSuit())) {
            
                match = true;
                break;
            }
        
        }
        
        System.out.println("You got a match: " + match);
    }
}
