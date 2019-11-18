package com.soues.jeude.model;

public class JoueurBean {

    private String nom;
    private int score;
    private GobeletBean gobelet;

    public JoueurBean(String nom) {
        this.nom = nom;
        score = 0;
        gobelet = new GobeletBean();
    }

    public void lancer() {
        gobelet.lancer();
    }

    public int getScoreDes() {
        return gobelet.getScoreDes();
    }

    public int getDe1() {
        return gobelet.getD1().getValeur();
    }

    public int getDe2() {
        return gobelet.getD2().getValeur();
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
