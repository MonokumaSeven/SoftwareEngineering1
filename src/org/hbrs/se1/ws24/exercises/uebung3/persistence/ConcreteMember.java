package org.hbrs.se1.ws24.exercises.uebung3.persistence;


public class ConcreteMember implements Member {
    int id;

    ConcreteMember(int id) {
        this.id=id;
    }

    public Integer getID() {
        return id;
    }

    public String toString() {
        return "Member (ID = " + id + ")";
    }
}
