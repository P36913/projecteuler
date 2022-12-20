package com.example.projecteuler;

public class pokerHand {
    public pokerCard[] hand;

    // constructor
    pokerHand(String[] hand) {
        this.hand[0] = new pokerCard(hand[0]);
        this.hand[1] = new pokerCard(hand[1]);
        this.hand[2] = new pokerCard(hand[2]);
        this.hand[3] = new pokerCard(hand[3]);
        this.hand[4] = new pokerCard(hand[4]);
    }

    public boolean isRoyalFlush() {
        if (isFlush() && isStraight() && 14 == getHighCard() && 10 == getLowCard()) {
            return true;
        }
        return false;
    }

    public boolean isStraightFlush() {
        return true;
    }

    public boolean isFourOfAKind() {
        return true;
    }

    public boolean isFullHouse() {
        return true;
    }

    public boolean isFlush() {
        String flushSuit = hand[0].suit;
        System.out.println(flushSuit);
        for (pokerCard card : hand) {
            if (!card.suit.equals(flushSuit)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
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
        for (pokerCard card: hand) {

        }
        return true;
    }

    public int getHighCard() {
        // Jack = 11, Queen = 12, King = 13, Ace = 14
        var highCard = 2;
        for (int i = 0; i < 5; i++) {
            if (hand[i].value > highCard) {
                highCard = hand[i].value;
            }
        }
        return highCard;
    }

    public int getLowCard() {
        // Jack = 11, Queen = 12, King = 13
        var lowCard = 14;
        for (int i = 0; i < 5; i++) {
            if (hand[i].value < lowCard) {
                lowCard = hand[i].value;
            }
        }
        return lowCard;
    }
}
