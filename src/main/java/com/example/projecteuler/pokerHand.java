package com.example.projecteuler;

import java.util.Comparator;
import java.util.Arrays;

public class pokerHand {
    public pokerCard[] hand = new pokerCard[5];

    // constructor
    pokerHand(String[] hand) {
        this.hand[0] = new pokerCard(hand[0]);
        this.hand[1] = new pokerCard(hand[1]);
        this.hand[2] = new pokerCard(hand[2]);
        this.hand[3] = new pokerCard(hand[3]);
        this.hand[4] = new pokerCard(hand[4]);
    }

    static private Comparator<pokerCard> ascPokerHand;

    static {
        ascPokerHand = new Comparator<pokerCard>(){
            @Override
            public int compare(pokerCard pc1, pokerCard pc2){
                return Integer.compare(pc1.getValue(), pc2.getValue());
            }
        };
    }

    public void sortAscValue(){
        Arrays.sort(hand, ascPokerHand);
    }

    public boolean isRoyalFlush() {
        sortAscValue(); // to get highest and lowest cards in the ends of the array
        if (isFlush() && isStraight() && 14 == hand[4].value && 10 == hand[0].value) {
            return true;
        }
        return false;
    }

    public boolean isStraightFlush() {
        if (isFlush() && isStraight()) {
            return true;
        }
        return false;
    }

    public boolean isFourOfAKind() {
        return true;
    }

    public boolean isFullHouse() {
        return true;
    }

    public boolean isFlush() {
        String flushSuit = hand[0].suit;
        for (pokerCard card : hand) {
            if (!card.suit.equals(flushSuit)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
        sortAscValue();
        int lowestCardValue = hand[0].value;
        int diff = 0; // difference between lowest card and current card in a loop
        for (pokerCard card : hand) {
            if (card.value - lowestCardValue != diff) {
                return false;
            }
            diff++;
        }
        return true;
    }

    public boolean isThreeOfAKind() {
        return true;
    }

    public boolean isTwoPairs() {
        return true;
    }

    public boolean isOnePair() {
        //String flushColor = hand[0].substring(1);
        // for (pokerCard card: hand) {

        // }
        return true;
    }
}
