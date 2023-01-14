/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;

/**
 * Creates a class that holds information about a premium member of a store object.
 * @author Jaxson Meisenhelter
 */
public class PremiumMember extends Member{

    private boolean premiumDue = false;
    private boolean card = false;
    /**
     * Adds a member to the Member array list.
     * @param name Name of the member.
     * @param spent Amount the member has spent.
     * @param premiumDue Stores whether or not a premium member needs to pay their monthly fee.
     * @param card Stores whether or not a premium member prefers to use card or cash for their payment method. Regular members are always false.
     */
    public PremiumMember(String name, float spent, boolean card, boolean premiumDue) {
        super(name, spent);
        this.card = card;
        this.premiumDue = premiumDue;
    }   
    
    /**
     * Returns whether or not a premium member needs to pay their monthly premium fee.
     * @return Stores whether or not a premium member needs to pay their monthly fee. Regular members are always false.
     */
    public boolean isPremiumDue() {
        return premiumDue;
    }
    /**
    * Returns whether or not a premium member uses a card as their payment method.
    * @return Stores whether or not a premium member prefers to use card or cash for their payment method. Regular members are always false.
    */
    public boolean isCard() {
        return card;
    }   
    
    /**
    * Sets whether or not a premium member needs to pay their monthly premium fee.
    * @param premiumDue Stores whether or not a premium member needs to pay their monthly fee. Regular members are always false.
    */
    public void setPremiumDue(boolean premiumDue) {
        this.premiumDue = premiumDue;
    }
    /**
     * Sets whether or not a premium member uses a card as their payment method.
     * @param card Stores whether or not a premium member prefers to use card or cash for their payment method. Regular members are always false.
     */
    public void setCard(boolean card) {
        this.card = card;
    }
    
}
