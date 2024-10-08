package org.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    @Test
    public void aTest() {
        GermanTranslator translator = new GermanTranslator();

        assertEquals("eins" , translator.translateNumber(1));
        assertEquals("Übersetzung der Zahl " + 0 + " nicht möglich " + 1.0 , translator.translateNumber(0));
        assertEquals("Übersetzung der Zahl " + 11 + " nicht möglich " + 1.0 , translator.translateNumber(11));
        assertEquals("Übersetzung der Zahl " + -1 + " nicht möglich " + 1.0 , translator.translateNumber(-1));

    }

}