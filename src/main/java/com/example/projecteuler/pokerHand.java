package com.example.projecteuler;

import java.util.Comparator;
import java.util.Arrays;

public class pokerHand {
    public pokerCard[] hand = new pokerCard[5];
    // set in countOccurences void method, to later check for pairs, etc.
    public int firstPairValue = 0, secondPairValue = 0, threeOfAKindValue = 0, fourOfAKindValue = 0, kicker = 0;

    // constructor
    pokerHand(String[] hand) {
        this.hand[0] = new pokerCard(hand[0]);
        this.hand[1] = new pokerCard(hand[1]);
        this.hand[2] = new pokerCard(hand[2]);
        this.hand[3] = new pokerCard(hand[3]);
        this.hand[4] = new pokerCard(hand[4]);
    }

    public int getFirstPairValue() {
        return firstPairValue;
    }

    public int getSecondPairValue() {
        return secondPairValue;
    }

    public int getThreeOfAKindValue() {
        return threeOfAKindValue;
    }

    public int getFourOfAKindValue() {
        return fourOfAKindValue;
    }

    public int getKicker() {
        return kicker;
    }

    static private Comparator<pokerCard> ascPokerHand;

    static {
        ascPokerHand = new Comparator<pokerCard>() {
            @Override
            public int compare(pokerCard pc1, pokerCard pc2) {
                return Integer.compare(pc1.getValue(), pc2.getValue());
            }
        };
    }

    public void sortAscValue() {
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
        if (fourOfAKindValue != 0) {
            return true;
        }
        return false;
    }

    public boolean isFullHouse() {
        if (firstPairValue != 0 && secondPairValue == 0 && threeOfAKindValue != 0) {
            return true;
        }
        return false;
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
        if (firstPairValue == 0 && secondPairValue == 0 && threeOfAKindValue != 0) {
            return true;
        }
        return false;
    }

    public boolean isTwoPairs() {
        if (firstPairValue != 0 && secondPairValue != 0) {
            return true;
        }
        return false;
    }

    public boolean isOnePair() {
        if (firstPairValue != 0 && secondPairValue == 0 && threeOfAKindValue == 0) {
            return true;
        }
        return false;
    }

    public void countOccurrences() {
        sortAscValue();
        int previousCard = 0;
        int counter = 0; // counts frequency of current card
        int pairCount = 0; //, threeOfAKindCount = 0, fourOfAKindCount = 0;
        int previousKicker = 0;

        for (pokerCard card : hand) {
            int current = card.getValue();

            if (previousCard == current) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter == 2) {
                kicker = previousKicker;

                pairCount++;
                if (pairCount == 1) {
                    firstPairValue = current;
                } else { // possible only 2
                    secondPairValue = current;
                }
            } else if (counter == 3) {
                pairCount--;
                //threeOfAKindCount++;
                if (pairCount == 0) {
                    firstPairValue = 0;
                } else { // possible only 1
                    secondPairValue = 0;
                }

                threeOfAKindValue = current;

            } else if (counter == 4) {
                // threeOfAKindCount--;
                // fourOfAKindCount++;
                threeOfAKindValue = 0;
                fourOfAKindValue = current;
            } else {
                if (kicker < current) {
                    previousKicker = kicker;
                    kicker = current;
                }
            }

            previousCard = current;
        }
    }

    public int evaluateHand() {
        // High card = 1
        // One Pair = 2
        // Two Pairs = 3
        // Three of a Kind = 4
        // Straight = 5
        // Flush = 6
        // Full House = 7
        // Four of a Kind = 8
        // Straight Flush = 9
        // Royal Flush = 10
        countOccurrences();
        if (isOnePair()) {
            return 2;
        } else if (isTwoPairs()) {
            return 3;
        } else if (isThreeOfAKind()) {
            return 4;
        } else if (isStraight()) {
            return 5;
        } else if (isFlush()) {
            return 6;
        } else if (isFullHouse()) {
            return 7;
        } else if (isFourOfAKind()) {
            return 8;
        } else if (isStraightFlush()) {
            return 9;
        } else if (isRoyalFlush()) {
            return 10;
        }

        // High card
        return 1;
    }

}
