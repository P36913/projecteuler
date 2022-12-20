# Solution for Problem 54 from Project Euler

This application is built on the Spring framework using VS Code. Application solves [this problem](https://projecteuler.net/problem=54) with a focus on object-oriented programming.


The application is solved by reading the provided file with two poker hands separated by a space character. Each line is separated and then divided into two players' hands. Player hands are objects which consist of 5 cards, cards are also objects. The main functionality is in pokerHand class, but p054 class has some logic as well - for hand comparison.

First, both hands are evaluated with pokerHand class method evaluateHand. This method returns numerical evaluation for the hand, where a higher number means a better hand. The method starts with more likely evaluations to avoid unnecessary calculations (Royal Flush is extremely rare compared to simple One Pair).

Next, evaluations are compared. Everything is clear when evaluations are different - in such cases, higher evaluation wins. In the case of equal evaluations, additional checks are needed. The additional check consists of comparing the cards' values (in case both hands have Straight - one with higher order wins, and similar for pairs and other combinations). In case when same evaluation and same combination, kickers are compared. No additional checks are present as the problem ensures that there are no draws and one player always has a better hand.

The pokerHand class has a sorting function, which orders hands in ascending by value way. The same class has methods to check every combination (only specified combination, meaning that method isFlush won't return true in the case of Royal Flush, only isRoyalFlush will return true). Also main logic sits behind 3 methods:
* isFlush
* isStraight
* countOccurrences

Other methods mainly reuse this logic. In the case of isFlush and isStraight, hands are just checked in a for loop for the same suit or increasing value by one. On the other hand, countOccurrences has slightly more complicated logic: it loops through sorted hands and looks for pairs, three of a kind, and four of a kind. As the hand is sorted by ascending order, the method compares only neighbour cards and in the case of four of a kind, it first counts it as a pair (after two iterations), later as a three of a kind (resulting in pair removal), and finally as a four of a kind (removing three of a kind).

