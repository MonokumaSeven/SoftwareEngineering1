package org.hbrs.se1.ws24.exercises.uebung8;

public class Adapter {

    //beispielhafte Methode zum Umwandeln des Suchauftrags in ein Query für die Schnittstelle des Reiseanbieters
    private QueryObject searchToQuery(s SuchAuftrag){
        QueryObject o = new QueryObject();
        s = (QueryObject) o;
    }

    //beispielhafte Methode zum Umwandeln des Query in ein Suchergebnis für die Reise-Portal-Schnittstelle
    private SuchErgebnis queryToResult(q QueryResult){
        SuchErgebnis s = new SuchErgebnis();
        q = (SuchErgebnis) s;
    }
}
