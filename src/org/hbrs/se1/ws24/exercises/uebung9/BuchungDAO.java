package org.hbrs.se1.ws24.exercises.uebung9;

import java.util.ArrayList;

public class BuchungDAO {
    private ArrayList buchungen;

    private BuchungDAO() {
        buchungen = new ArrayList();
    }


    private static BuchungDAO newBuchungDAO() {
        BuchungDAO b_DAO = new BuchungDAO();
        return b_DAO;
    }

    private Buchung getBuchung(int i){
        Buchung b = (Buchung) buchungen.get(i);
        return b;
    }

    private void addBuchung(Buchung b){
        buchungen.add(b);
    }

    private void deletBuchung(int i){
        buchungen.remove(i);
    }

}
