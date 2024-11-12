package org.hbrs.se1.ws24.exercises.uebung4.finalversion;

import java.io.Serializable;

public class UserStory implements Comparable<UserStory>, Serializable {

    private String titel;
    private int aufwand = 0;
    private int id = 0;
    private int mehrwert = 0;
    private int risk = 0;
    private int strafe = 0;
    private double prio = 0.0;
    private String project;
    private String akzeptanzkrit;


    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }




    public UserStory(int id, String titel, String akzeptanzkrit, int mehrwert, int strafe,
                     int aufwand, int risk) {
        this.id = id;
        this.titel = titel;
        this.akzeptanzkrit = akzeptanzkrit;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risk = risk;
        this.prio = calcPrio(mehrwert,strafe,aufwand,risk);
    }

    public UserStory() {
    }

    public double getPrio() {
        return prio;
    }
    public void setPrio(double prio) {
        this.prio = prio;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAkzeptanzkrit() {
        return akzeptanzkrit;
    }
    public void setAkzeptanzkrit(String akzeptanzkrit) {
        this.akzeptanzkrit = akzeptanzkrit;
    }

    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }

    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }

    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    /*
     * Methode zum Vergleich zweier UserStories.
     * Vergleich ist implementiert auf Basis des Vergleichs
     * von zwei Prio-Werten.
     */
    public int compareTo(UserStory input) {
        if ( input.getPrio() == this.getPrio() ) {
            return 0;
        }

        if ( input.getPrio() > this.getPrio() ) {
            return 1;
        }
        else return -1;
    }

    /*
     * Methode zum Berechnen der Priorität.
     * Berechnung ist implementiert auf Basis der Formel
     * von Gloger und die 4 Kennzahlen.
     */
    public double calcPrio(int mehrwert, int strafe, int aufwand, int risiko){
        double priority;
        if (mehrwert >= 1 && mehrwert <= 5){
            if (strafe >= 1 && strafe <= 5){
                if (aufwand > 0){
                    if (risiko >= 1 && risiko <= 5){
                        priority = (double) (mehrwert + strafe) /(aufwand+risiko);
                        return priority;
                    } else {
                        throw new IllegalArgumentException("Risiko muss eine Zahl zwischen 1 und 5 sein.");
                    }
                } else {
                    throw new IllegalArgumentException("Aufwand muss eine positive Zahl sein.");
                }
            } else {
                throw new IllegalArgumentException("Strafe muss eine Zahl zwischen 1 und 5 sein.");
            }
        } else {
            throw new IllegalArgumentException("Mehrwert muss eine Zahl zwischen 1 und 5 sein.");
        }
    }

    @Override
    public String toString() {
        String s = id + "; " + titel + "; " + akzeptanzkrit + "; " + mehrwert + "; " + strafe + "; " + aufwand + "; " + risk + "; " + prio;
        return s;
    }
}

