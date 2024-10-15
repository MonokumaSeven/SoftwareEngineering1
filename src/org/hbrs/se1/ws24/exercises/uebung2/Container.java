package org.hbrs.se1.ws24.exercises.uebung2;
import java.util.*;

public class Container {

    ArrayList list = new ArrayList();

    public void addMember(Member member) throws ContainerException {
        if (!list.contains(member)) {
            list.add(member);
        } else {
            throw new ContainerException("Das Member-Objekt mit der ID "+member.getID()+" ist bereits vorhanden!");
        }
    }

    public String deleteMember(Integer id) {
        String s="";
        if (list.contains(id)) {
            list.remove(id);
            s = "Das Member-Objekt mit der ID "+id+" wurde gelöscht!";
        } else {
            s = "Das Member-Objekt mit der ID "+id+" ist nicht vorhanden!";
        }
        return s;
    }

    public void dump(){
        if (!list.isEmpty()){
            for (int i=0; i<list.size(); i++){
                System.out.println(list.get(i).toString());
            }
        }
    }

    public int size(){
        return list.size();
    }
}
