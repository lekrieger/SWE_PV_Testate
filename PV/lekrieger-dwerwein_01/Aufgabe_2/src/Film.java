public class Film {

    private String titel;
    private long dauer; // in Minuten
    private String erscheinungsjahr;
    private String genre;
    private int fsk;

    public Film(String titel, long dauer, String erscheinungsjahr, String genre, int fsk) {
        this.titel = titel;
        this.dauer = dauer;
        this.erscheinungsjahr = erscheinungsjahr;
        this.genre = genre;
        this.fsk = fsk;
    }

    public String getTitel() {
        return titel;
    }

    public long getDauer() {
        return dauer;
    }

    public String getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public String getGenre() {
        return genre;
    }

    public int getFsk() {
        return fsk;
    }

    public void setTitel(String titel) {
        this.titel = titel; 
    }

    public void setDauer(long dauer) {
        this.dauer = dauer;
    }

    public void setErscheinungsjahr(String erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }


    public static void main(String[] args) {
        
        // neue Instanzen erstellen
        Film StarWars = new Film("Star Wars", 121, "1977", "Science-Fiction", 12);
        Film Inception = new Film("Inception", 148, "2010", "Science-Fiction", 12);
        Film TheDarkKnight = new Film("The Dark Knight", 152, "2008", "Action", 12);

        // Werte ausgeben (Getter)
        System.out.println("Titel: " + StarWars.getTitel());
        System.out.println("Inception Dauer: " + Inception.getDauer());
        System.out.println("TheDarkKnight Genre: " + TheDarkKnight.getGenre()); 

        System.out.println();

        // Setter testen
        System.out.println("Neue, geänderte Werte:");
        Inception.setDauer(99);
        System.out.println("Inception Dauer: " + Inception.getDauer());
        TheDarkKnight.setGenre("Komödie");
        System.out.println("TheDarkKnight Genre: " + TheDarkKnight.getGenre());
    }
}
