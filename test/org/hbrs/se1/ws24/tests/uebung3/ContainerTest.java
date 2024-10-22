package org.hbrs.se1.ws24.tests.uebung3.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.Container;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContainerTest {

    private Container c;

    @BeforeEach
    void setUp(){
        c = Container.getInstance();
    }


    @Test
    public void storeLoadTest() {
        ConcreteMember m1 = new ConcreteMember(1);
        ConcreteMember m2 = new ConcreteMember(2);
        assertEquals(0, c.size());
        try {
            c.addMember(m1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        asserEquals(1, c.size());
        try {
            c.addMember(m2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        asserEquals(2, c.size());
        c.store();
        c.deleteMember(1);
        assertEquals(1, c.size());
        c.deleteMember(2);
        assertEquals(0, c.size());
        c.load();
        assertEquals(2, c.size());
    }


    @Test
    public void notImplementedMongoDBTest() {
        try {
            c.setStrategy(new PersistenceStrategyMongoDB<Member>());
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable, e.getExceptionTypeType());
        }
    }


    @Test
    public void noStrategyTest() {
        try {
            c.setStrategy(null);
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getExceptionTypeType());
        }
    }


}