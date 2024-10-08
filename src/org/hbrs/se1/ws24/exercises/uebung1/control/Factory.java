package org.hbrs.se1.ws24.exercises.uebung1.control;

public class Factory {
    public static Translator createTranslator() {
        return new GermanTranslator();

    }
}
