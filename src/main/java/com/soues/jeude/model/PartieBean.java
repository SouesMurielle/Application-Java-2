package com.soues.jeude.model;

public class PartieBean {

    public static final int NB_LANCER = 10;
    public static final int NB_A_ATTEINDRE = 7;

    private int tourEnCours;
    private JoueurBean j1, j2, jc;

    public PartieBean(String nomJ1, String nomJ2) {
        tourEnCours = 1;
        j1 = new JoueurBean(nomJ1);
        j2 = new JoueurBean(nomJ2);
        jc = j1;
    }

    public void ajouter1Tour() {
        tourEnCours++;
    }

    public void changerJoueur() {
        if (jc == j1)
            jc = j2;
        else jc = j1;
    }

    public JoueurBean getJ1() {
        return j1;
    }

    public JoueurBean getJ2() {
        return j2;
    }

    public int getTourEnCours() {
        return tourEnCours;
    }

    public void setTourEnCours(int tourEnCours) {
        this.tourEnCours = tourEnCours;
    }

    public JoueurBean getJc() {
        return jc;
    }
}
