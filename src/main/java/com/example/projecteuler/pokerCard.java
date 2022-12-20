package com.example.projecteuler;

import java.util.HashMap;

public class pokerCard {

    public int value;
    public String suit;
    private static HashMap<String, Integer> valueByCode = valueMap.valueByCode;

    pokerCard(String card) {
        this.value = valueByCode.get(card.substring(0, 1));
        this.suit = card.substring(1);
    }
    
}
