package org.hbrs.se1.ws24.tests.uebung4;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung4.finalversion.Container;

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
        UserStory u1 = new UserStory(1,test,testkrit,2,4,13,5);
        UserStory u2 = new UserStory(2,test2,testkrit2,5,1,7,2);
        assertEquals(0, c.size());
        try {
            c.enter(u1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        asserEquals(1, c.size());
        try {
            c.enter(u2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        asserEquals(2, c.size());
        c.store();
        c.remove(1);
        assertEquals(1, c.size());
        c.remove(2);
        assertEquals(0, c.size());
        c.load();
        assertEquals(2, c.size());
    }

    @Test
    public void enterTest() {
        UserStory u1 = new UserStory(1,test,testkrit,2,4,13,5);
        UserStory u2 = new UserStory(1,test2,testkrit2,5,1,7,2);
        c.enter(u1);
        assertEquals(1, c.size());
        c.enter(u2);
        assertEquals(1, c.size());
    }

    @Test
    public void dumpTest() {
        UserStory u1 = new UserStory(1,test,testkrit,2,4,13,5);
        UserStory u2 = new UserStory(2,test2,testkrit2,5,1,7,2);
        try {
            c.enter(u1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        try {
            c.enter(u2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        String s = "Id; Titel; Akzeptanzkriterium; Mehrwert; Strafe; Aufwand; Risiko; Priorität \n 1; test; testkrit; 2; 4; 13; 5; 0.33 \n 2; test2; testkrit2; 5; 1; 7; 2; 0.66"
        assertEquals(s, c.dump())
    }

    @Test
    public void dumpProjectTest(){
        UserStory u1 = new UserStory(1,test,testkrit,2,4,13,5);
        UserStory u2 = new UserStory(2,test2,testkrit2,5,1,7,2);
        u1.setProject("testProject");
        try {
            c.enter(u1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        try {
            c.enter(u2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        String s = "Id; Titel; Akzeptanzkriterium; Mehrwert; Strafe; Aufwand; Risiko; Priorität \n 1; test; testkrit; 2; 4; 13; 5; 0.33"
        assertEquals(s, c.dumpProject("testProject"))
    }


}