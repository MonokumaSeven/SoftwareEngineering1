package org.hbrs.se1.ws24.exercises.uebung9;

public abstract class Document {
    private int id;

    public abstract int getSize();

    public int getID() {
        return id;
    }

    public void setID(int newID) {
        id = newID;
    }
}
