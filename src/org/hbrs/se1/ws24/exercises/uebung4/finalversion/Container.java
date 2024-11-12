package org.hbrs.se1.ws24.exercises.uebung4.finalversion;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws24.exercises.uebung4.finalversion.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung4.finalversion.UserStory;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Container {
	 
	// Interne ArrayList zur Abspeicherung der Objekte vom Type UserStory
	private List<UserStory> liste = null;
	
	//Container Instanz
	private static Container instance = null;

	public static Container getInstance() {
		if (instance == null) {
			instance = new Container();
		}
		return instance;
	}
	
	// URL der Datei, in der die Objekte gespeichert werden 
	final static String LOCATION = "allStories.ser";


	private Container(){
		liste = new ArrayList<UserStory>();
	}

	//Speichern einer Liste mit User Stories
	public void store() throws ContainerException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream( Container.LOCATION );
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject( this.liste );
			System.out.println( this.size() + " User Stories wurden erfolgreich gespeichert!");
		}
		catch (IOException e) {
			e.printStackTrace();
		  //  Delegation in den aufrufendem Context
		  // (Anwendung Pattern "Chain Of Responsibility)
		  throw new ContainerException("Fehler beim Abspeichern");
		}
	}

	//Laden einer Liste mit User Stories
	public void load() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
		  fis = new FileInputStream( Container.LOCATION );
		  ois = new ObjectInputStream(fis);
		  
		  // Auslesen der Liste
		  Object obj = ois.readObject();
		  if (obj instanceof List<?>) {
			  this.liste = (List) obj;
		  }
		  System.out.println("Es wurden " + this.size() + " User Stories erfolgreich geladen!");
		}
		catch (IOException e) {
			System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
		}
		catch (ClassNotFoundException e) {
			System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
		}
		finally {
		  if (ois != null) try { ois.close(); } catch (IOException e) {}
		  if (fis != null) try { fis.close(); } catch (IOException e) {}
		}
	}

	//Hinzufügen User Story
	public void enter(UserStory  userStory) throws ContainerException {
		if (contains(userStory)) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		liste.add(userStory);
	}

	//Prüft ob User Story bereits enthalten
	private boolean contains( UserStory userStory ) {
		int ID = userStory.getId();
		for ( UserStory userStory1 : liste) {
			if ( userStory1.getId() == ID ) {
				return true;
			}
		}
		return false;
	}

	//Anzahl User Stories in Liste
	public int size() {
		return liste.size();
	}

	//Ausgabe aktuelle Liste in tabellarischer Form sortiert nach Priorisierung
	public void dump() {
		List<UserStory> sortedList = this.liste;
		sortedList.sort(Comparator.comparing(UserStory::getPrio));
		System.out.println("ID; Titel; Akzeptanz-Kriterium; Mehrwert; Strafe; Aufwand; Risiko; Priorität");
		for (UserStory userStory : sortedList) {
			System.out.println(userStory.toString());
		}
	}

	//Ausgabe User Stories aus bestimmten Projekt
	public void dumpProject(String project) {
		List<UserStory> projectList = new ArrayList<>();
		for ( UserStory userStory : liste) {
			if (Objects.equals(project, userStory.getProject())){
				projectList.add(userStory);
			}
		}
		projectList.sort(Comparator.comparing(UserStory::getPrio));
		System.out.println("ID; Titel; Akzeptanz-Kriterium; Mehrwert; Strafe; Aufwand; Risiko; Priorität");
		for (UserStory userStory : projectList) {
			System.out.println(userStory.toString());
		}
	}

	//Entfernen User Story
	public void remove(int id){
		for ( UserStory userStory : liste) {
			if (userStory.getId() == id) {
				liste.remove(userStory);
			}
		}
	}

}
