package Apps;

/**
 * Class (blueprint) of cards 
 * 
 * @author ITSC 2214
 * @version 1.0
 */
public class Card {

    /** Suit of spades. */
    public static final int SPADES = 0;

    /** Suit of hearts. */
    public static final int HEARTS = 1;

    /** Suit of diamonds. */
    public static final int DIAMONDS = 2;

    /** Suit of clubs. */
    public static final int CLUBS = 3;

    /** Rank of ace, equivalent to 1. */
    public static final int ACE = 1;

    /** Rank of jack. */
    public static final int JACK = 11;

    /** Rank of queen. */
    public static final int QUEEN = 12;

    /** Rank of king. */
    public static final int KING = 13;

    /** Number or face on this Card. */
    private int rank;

    /** Suit of this Card. */
    private int suit;

    /**
     * Constructor: Initialize the rank and suit.
     * @param rank rank number id
     * @param suit suit id
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
    * Return true if and only if that Card has the same 
    * rank as
    * this one.  Suit is ignored.
    * @param that input another card reference
    * @return whether this card is equal to the given 
    * input card
    */
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Card thatCard = (Card)that;
        return rank == thatCard.rank;
    }

    /** Return the rank of this Card.  
     * @return rank id of this card itself
     */
    public int getRank() {
        return rank;
    }

    /** Return the suit of this Card. 
     * @return suit id of this card itself
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Return the string text representation of this card
     * itself
     * @return String card information
     */
    public String toString() {
        return "" + "-A23456789TJQK".charAt(rank)
                + "shdc".charAt(suit);
    }
}
