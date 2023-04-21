package com.psl.gems.play;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cardsInHand;

    public Player(String name) {
        this.name = name;
        this.cardsInHand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }
    
    public String getName() {
    	return this.name;
    }

    public Card getHighestCard() {
        Card highestCard = null;
        int highestValue = -1;
        for (Card card : cardsInHand) {
            int cardValue = card.getValue();
            if (cardValue > highestValue) {
                highestValue = cardValue;
                highestCard = card;
            }
        }
        return highestCard;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }
}