package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import java.util.ArrayList;

public class MemberView {
    public void dump(ArrayList<Member> list){
        if (!list.isEmpty()){
            for (int i=0; i<list.size(); i++){
                System.out.println(list.get(i).toString());
            }
        }
    }
}
