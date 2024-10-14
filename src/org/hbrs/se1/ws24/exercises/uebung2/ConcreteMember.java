package org.hbrs.se1.ws24.exercises.uebung2;

public class ConcreteMember implements Member{
    static int id=0;

    ConcreteMember() {
        id+=1;
    }

    public Integer getID(){
        return id;
    }

    public String toString(){
        return "Member (ID = "+id+")";
    }
}
