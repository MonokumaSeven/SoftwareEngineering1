package org.hbrs.se1.ws24.exercises.uebung9;

public class TestClient {
    public static void main(String[] args) {
        ComplexDocument doc0 = new ComplexDocument();
        TextDocument doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!", Encoding.UTF8);
        ComplexDocument doc3 = new ComplexDocument();
        TextDocument doc5 = new TextDocument("Software Engineering ist eine Vorlesung in den Studiengaengen BIS und BCS", Encoding.UTF32);
        GraficDocument doc4 = new GraficDocument("localhost:8080");

        doc0.addDocument(doc2);
        doc0.addDocument(doc3);
        doc3.addDocument(doc4);
        doc3.addDocument(doc5);

        int docSize = doc0.getSize();

        System.out.println("Größe des Dokument0(in Bytes): " + docSize);
    }
}
