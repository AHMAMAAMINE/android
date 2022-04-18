package com.example.navigationdrawer.entities;

public class Stats {
    int nbr;
    int annee;

    public Stats(int nbr, int annee) {
        this.nbr = nbr;
        this.annee = annee;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
