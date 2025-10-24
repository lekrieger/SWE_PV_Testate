// Die Methode initSystem bündelt Aufgaben, die nur zeitlich (beim Start) zusammenhängen

class SystemManager {

    // Methode gruppiert Operationen, die keinen direkten funktionalen Zusammenhang haben
    // einziger Zusammenhang ist der Zeitpunkt: "Systemstart"

    public void initSystem() {

        System.out.println("1. Datenbank wird gestartet...");
        System.out.println("2. Netzwerkverbindung wird hergestellt...");       
        System.out.println("3. Benutzeroberfläche wird geladen...");

    }
}

// Aufrufende Klasse
public class TemporaleBindung {
    public static void main(String[] args) {
        SystemManager manager = new SystemManager();

        // Alle Tasks auf einmal aufrufen
        manager.initSystem();
    }
}

// temporal, da sie zur gleichen Zeit ausgeführt werden müssen