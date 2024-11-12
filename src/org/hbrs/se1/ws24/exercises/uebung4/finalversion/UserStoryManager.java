package org.hbrs.se1.ws24.exercises.uebung4.finalversion;

import java.util.*;

public class UserStoryManager {
    static Scanner sc;
    static Container container;
    static boolean active;

    //Startet System zur Verwaltung von User Stories
    public static void run() throws Exception {
        sc = new Scanner(System.in);
        active = true;
        container = Container.getInstance();
        while (active) {
            getCommand();
        }
    }

    //Erkennt eingegebene Befehle
    private static void getCommand() throws Exception {
        System.out.println("> ");
        String input = sc.nextLine();
        String[] commands = input.split(" ");
        switch (commands[0]) {
            case "enter":
                enter(commands);
                break;
            case "store":
                store();
                break;
            case "load":
                load();
                break;
            case "dump":
                dump(commands);
                break;
            case "exit":
                exit();
                break;
            case "help":
                help();
                break;
            default:
                break;
        }
    }

    //Ausführung der Befehle

    private static void enter(String[] parameter) {
        if (parameter.length != 8) {
            System.out.println("Fehler bei Parametern: Um eine User Story einzutragen sind folgende Parameter nötig: ID, Titel, Akzeptanzkriterium, Mehrwert, Strafe, Aufwand, Risiko.");
        } else {
            int id = Integer.parseInt(parameter[1]);
            String title = parameter[2];
            String krit = parameter[3];
            int mehrwert = Integer.parseInt(parameter[4]);
            int strafe = Integer.parseInt(parameter[5]);
            int aufwand = Integer.parseInt(parameter[6]);
            int risiko = Integer.parseInt(parameter[7]);
            UserStory tmpStory = new UserStory(id,title,krit,mehrwert,strafe,aufwand,risiko);
            try {
                container.enter(tmpStory);
            } catch (Exception e) {
                System.out.println("Fehler beim Hinzufügen der User Story");
            }
        }
    }

    private static void store() throws Exception {
        try {
            container.store();
        } catch (ContainerException e) {
            System.out.println("Speichern fehlgeschlagen.");
        }

    }

    private static void load() throws Exception {
        try {
            container.load();
        } catch (Exception e) {
            System.out.println("Laden fehlgeschlagen.");
        }
    }

    private static void dump(String[] parameters) {
        if (parameters.length == 3){
            if (Objects.equals(parameters[1], "projekt")){
                try {
                    container.dumpProject(parameters[2]);
                } catch (Exception e){
                    System.out.println("Fehler beim Ausgeben der User Stories");
                }
            } else {
                System.out.println("Fehler bei Parametern, richtiges Format: dump projekt [Projekt-Name]");
            }
        } else if (parameters.length == 1) {
            container.dump();
        } else {
            System.out.println("Fehler bei Parameter, mögliche Eingaben: dump oder dump projekt [Projekt-Name]");
        }
    }

    private static void exit() {
        active = false;
        sc.close();
        container = null;
    }

    private static void help() {
        String[] commands = {"enter: Eingabe einer User Story", "store: Abspeichern der User Stories auf Datenträger", "load: Laden von User Stories von Datenträger", "dump: Ausgabe User Stories sortiert nach Priorität(Wahlweise von nur einem bestimmen Projekt)", "exit: Beenden der Anwendung"};
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
