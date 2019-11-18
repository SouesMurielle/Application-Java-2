package com.soues.jeude.model;

import java.util.Random;

public class DeBean {

    private static final int NB_FACE = 6;
    private static final Random random = new Random();
    private int valeur;

    public void lancer() {
        valeur = random.nextInt(NB_FACE)+1;
    }

    public int getValeur() {
        return valeur;
    }
}
