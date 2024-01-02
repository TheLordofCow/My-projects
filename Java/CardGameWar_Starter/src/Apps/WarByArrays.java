package Apps;

import Apps.Deck;
import Apps.Card;
import DataStructures.ArrayStack;
import ADTs.StackADT;
import ADTs.QueueADT;
import DataStructures.ArrayCircularQueue;
import java.util.Scanner;

/**
 * Simulation of card game war.
 * In the simulation, we use array circular list queues 
 and array stacks.
 The card game WarByArrays for two players.
 * 
 * @author ITSC 2214
 * @version 1.0
 */
public class WarByArrays {

    /** For reading from the Console. */
    public static final Scanner INPUT = new Scanner(System.in);

    /** Player 1's pile of Cards. */
    private QueueADT<Card> hand1;

    /** Player 2's pile of Cards. */
    private QueueADT<Card> hand2;

    /**
     * Deal all the Cards out to the players.
     * @param isShuffled flag to determine whether
     *                   to randomly shuffle cards
     */
    public WarByArrays(boolean isShuffled) {
        //TODO Initialize two piles in hand
        //     Initialize the hand1 and hand2 variables
        hand1 = new ArrayCircularQueue<Card>();
        hand2 = new ArrayCircularQueue<Card>();
        
        Deck deck = new Deck();
        if (isShuffled) {
            deck.shuffle();
        }
        while (!(deck.isEmpty())) {
            //TODO deal a card from the deck for each player 
            //and add the card to the corresponding 
            //pile. deck.deal() is to deal a card
            //insert the dealt card into hand1 and hand2 
            //data structures.
            hand1.enqueue(deck.deal());
            hand2.enqueue(deck.deal());
        }
        System.out.print("#cards in hand1: " 
                + hand1.size());
        System.out.println("#cards in hand2: " 
                + hand2.size());
    }

    /**
     * Give all of the Cards played to the winning player.
     * @param stack1 the card stack in front of player 1
     * @param stack2 the card stack in front of player 2
     * @param winner the card pile of winner's hands
     */
    public void give(StackADT<Card> stack1,
                     StackADT<Card> stack2,
                     QueueADT<Card> winner) {
        if (winner == hand1) {
            System.out.println("Player 1 gets the cards");
        } 
        else {
            System.out.println("Player 2 gets the cards");
        }

        try {
            while (!(stack1.isEmpty())) {
                winner.enqueue(stack1.pop());
            }
            while (!(stack2.isEmpty())) {
                winner.enqueue(stack2.pop());
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Play until one player runs out of Cards. */
    public void play() {
        int count = 1;
        while (!(hand1.isEmpty() || hand2.isEmpty())) {
            //System.out.print("\nHit return to play round: ");
            //INPUT.nextLine();
            playRound();
            if (hand1.isEmpty()) {
                System.out.println("Player 2 wins!");
            }
            if (hand2.isEmpty()) {
                System.out.println("Player 1 wins!");
            }
            System.out.print("In round " + count 
                    + " #cards in hand1: " + hand1.size());
            System.out.println("#cards in hand2: "
                    + hand2.size());
            count++;
        }
    }

    /** Play one round. */
    public void playRound() {
        try {
            StackADT<Card> stack1 = new ArrayStack<Card>();
            StackADT<Card> stack2 = new ArrayStack<Card>();

            stack1.push(hand1.dequeue());
            stack2.push(hand2.dequeue());

            System.out.print("#(cards in hand1)=" 
                    + hand1.size());
            System.out.print(" #(cards in hand2)=" 
                    + hand2.size());
            System.out.print(" #(cards in stack1)=" 
                    + stack1.size());
            System.out.println(" #(cards in stack2)=" 
                    + stack2.size());

            do {
                Card card1 = stack1.peek();
                Card card2 = stack2.peek();
                System.out.println(card1 + " " + card2);
                QueueADT<Card> winner = null;
                if (card1.getRank() > card2.getRank()) {
                    winner = hand1;
                }
                if (card1.getRank() < card2.getRank()) {
                    winner = hand2;
                }
                if (winner != null) {
                    give(stack1, stack2, winner);
                    return;
                }
                System.out.print("#(cards in hand1)=" 
                        + hand1.size());
                System.out.print(" #(cards in hand2)=" 
                        + hand2.size());
                System.out.print(" #(cards in stack1)=" 
                        + stack1.size());
                System.out.println(" #(cards in stack2)=" 
                        + stack2.size());
            } while (!settledByWar(stack1, stack2));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Play a war over stack1 and stack2.  If this ends the 
     * game because
     * one player runs out of cards, give the cards to the 
     * winning
     * player and return true.  Otherwise, return false. 
     * @param stack1 the card stack in front of player 1
     * @param stack2 the card stack in front of player 2
     * @return is settled by war?
     */
    public boolean settledByWar(StackADT<Card> stack1, 
            StackADT<Card> stack2) {
        System.out.println("War!");
        try {
            for (int i = 0; i < 4; i++) {
                if (hand1.isEmpty()) {
                    give(stack1, stack2, hand2);
                    return true;
                }
                stack1.push(hand1.dequeue());
                if (hand2.isEmpty()) {
                    give(stack1, stack2, hand1);
                    return true;
                }
                stack2.push(hand2.dequeue());
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Create and play the game.
     * @param args no required argument
     */
    public static void main(String[] args) {
        System.out.println("Welcome to War.");
        WarByArrays game = new WarByArrays(true);
        game.play();
    }
}

