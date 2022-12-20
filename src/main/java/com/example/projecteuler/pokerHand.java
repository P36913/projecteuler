package com.example.projecteuler;

public class pokerHand {
    public String[] hand;

    // constructor
    pokerHand(String[] hand) {
        this.hand = hand;
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
        String flushColor = hand[0].substring(1);
        System.out.println(flushColor);
        for (String card : hand) {
            if (!card.substring(1).equals(flushColor)) {
                System.out.println("#### " + flushColor + " " + card.substring(1));
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
        return true;
    }

    public int getHighCard() {
        // Jack = 11, Queen = 12, King = 13, Ace = 14
        return 1;
    }

    public int getLowCard() {
        // Jack = 11, Queen = 12, King = 13
        return 1;
    }
}
