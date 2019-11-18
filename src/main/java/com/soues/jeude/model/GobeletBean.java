package com.soues.jeude.model;

public class GobeletBean {

    private DeBean d1, d2;

    public GobeletBean() {
        d1 = new DeBean();
        d2 = new DeBean();
    }

    public void lancer() {
        d1.lancer();
        d2.lancer();
    }

    public int getScoreDes() {
        return d1.getValeur() + d2.getValeur();
    }

    public DeBean getD1() {
        return d1;
    }

    public DeBean getD2() {
        return d2;
    }

}
