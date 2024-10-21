package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        Container c = Container.getInstance();
        ConcreteMember m1 = new ConcreteMember(1);
        MemberView mv = new MemberView();
        PersistenceStrategy<Member> strategy = new PersistenceStrategyStream<>();
        c.setStrategy(strategy);

        try {
            c.addMember(m1);
        } catch (ContainerException e){
            e.printStackTrace();
        }
        try {
            c.store();
        } catch (PersistenceException e){
            e.printStackTrace();
        }

        ArrayList<Member> list = c.getCurrentList();
        mv.dump(list);

        try {
            c.deleteMember(1);
        } catch (Exception e){
            e.printStackTrace();
        }

        list = c.getCurrentList();
        mv.dump(list);

        try {
            c.load();
        } catch (PersistenceException e){
            e.printStackTrace();
        }

        list = c.getCurrentList();
        mv.dump(list);

    }
}
