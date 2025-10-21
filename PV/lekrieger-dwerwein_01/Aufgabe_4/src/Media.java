public class Media {
    
    String titel;
    String autor;
    long jahr;

    // Konstruktor
   public Media(String t, String a, long j) {
        this.titel = t;
        this.autor = a;
        this.jahr = j;
    }
    // Verkettung 
    public Media(String t) {
        this(t, "Autor", 2000);
    }

    // leerer / default Konstruktor
   public Media() {
        this("n.a.");
    }

    String getTitle() {
        return this.titel;
    }
    String getAuthor() {
        return this.autor;
    }
    long getYear() {
        return this.jahr;
    }
    
    // Testing
    public static void main(String[] args){
        Book b1 = new Book("Weiße Nächte","Dostojewski",1848);
        System.out.println("Titel: "+b1.titel + ", Autor: "+b1.autor+", Erscheinungsjahr: "+b1.jahr);
    }
}
