package org.hbrs.se1.ws24.exercises.uebung3.persistence;


import java.util.ArrayList;

public class Container {

    ArrayList list = null;

    private static Container instance = null;
    private static PersistenceStrategy<Member> persistenceStrategy;

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    private Container() {
        this.list = new ArrayList();
    }

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


    public void store() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "No Strategy is set!");
        }
        persistenceStrategy.save(list);
    }

    public void load() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "No Strategy is set!");
        }
        list = (ArrayList) persistenceStrategy.load();
    }

    public int size(){
        return list.size();
    }

    public void setStrategy(PersistenceStrategy<Member> strategy) {
        persistenceStrategy = strategy;
    }

    public ArrayList<Member> getCurrentList() {
        return this.list;
    }
}
