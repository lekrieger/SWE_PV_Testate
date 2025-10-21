public class Book extends Media {

    // Vererbte Konstruktoren von Media
    public Book(String t, String a, long y) {
        super(t, a, y);
    }
        
    public Book(String t) {
        super(t);
    }
        
    public Book(){
        super();
    }
}
