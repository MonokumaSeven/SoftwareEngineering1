package org.hbrs.se1.ws24.tests.uebung2;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung2.Container;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContainerTest {

    Container container;

    @BeforeEach
    void setUp(){
        container = new Container();
    }

    @AfterEach
    void tearDown(){
        container = null;
    }

    @Test
    public void addTest() {
        ConcreteMember m1 = new ConcreteMember(0);
        ConcreteMember m2 = new ConcreteMember(0);
        ConcreteMember m3 = new ConcreteMember(1);

        assertDoesNotThrow(() -> container.addMember(m1));
        assertThrows(ContainerException.class, () -> container.addMember(m2));
        assertDoesNotThrow(() -> container.addMember(m3));
    }

    @Test
    public void deleteTest() throws ContainerException {
        ConcreteMember m1 = new ConcreteMember(0);

        assertEquals("Das Member-Objekt mit der ID 0 ist nicht vorhanden!", container.deleteMember(0));
        container.addMember(m1);
        assertEquals("Das Member-Objekt mit der ID 0 ist nicht vorhanden!", container.deleteMember(1));
        assertEquals("Das Member-Objekt mit der ID 0 wurde gelöscht!", container.deleteMember(0));
    }

    @Test
    public void dumpTest() throws ContainerException {
        ConcreteMember m1 = new ConcreteMember(0);
        ConcreteMember m2 = new ConcreteMember(1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        container.dump();
        String expectedOutput1 = "";
        assertEquals(expectedOutput1, outContent.toString());

        System.setOut(new PrintStream(outContent));
        container.addMember(m1);
        container.dump();
        String expectedOutput2 = "Member (ID = 0)";
        assertEquals(expectedOutput2, outContent.toString());

        System.setOut(new PrintStream(outContent));
        container.addMember(m2);
        container.dump();
        String expectedOutput3 = "Member (ID = 0)\nMember (ID = 1)";
        assertEquals(expectedOutput3, outContent.toString());
    }

    @Test
    public void sizeTest() throws ContainerException {
        ConcreteMember m1 = new ConcreteMember(0);
        ConcreteMember m2 = new ConcreteMember(1);

        assertEquals(0, container.size());

        container.addMember(m1);
        asserEquals(1, container.size());

        container.addMember(m2);
        asserEquals(2, container.size());
    }

}