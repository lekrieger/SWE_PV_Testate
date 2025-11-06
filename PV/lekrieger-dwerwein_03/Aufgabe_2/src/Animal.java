public class Animal {
    
    int alter;
    String name;

    public Animal(int alter, String name) {
        this.alter = alter;
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + ", Alter: " + alter;
    }
}