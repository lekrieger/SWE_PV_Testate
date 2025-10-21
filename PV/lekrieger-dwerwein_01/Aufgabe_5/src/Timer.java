public class Timer {

    public static void zaehleRunter(int n) {

        if (n >= 0) {
            System.out.println(n);
            zaehleRunter(n - 1);
        } 
        else {
            System.out.println("Fertig!");
        }
    
    }
        
    public static void main(String[] args) {
        zaehleRunter(5);
    }

    
}
