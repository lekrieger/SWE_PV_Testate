/**
 * A Class, showing information about different drinks in a cafe.
 */

public class Cafe {

    public static void main(String[] args) {

        IcedTea icedTea = new IcedTea();
        Coffee coffee = new Coffee();
        Drink espresso = new Coffee();
        Drink lemon = icedTea;

        System.out.println("1: coffee.temperature           		: " + coffee.temperature);
        System.out.println("2: icedTea.getTemperature()     		: " + icedTea.getTemperature());
        System.out.println("3: coffee.getTemperature()      		: " + coffee.getTemperature());
        System.out.println("4: ((IcedTea) lemon).temperature		: " + ((IcedTea) lemon).temperature);
        System.out.println("5: ((Drink) coffee).temperature 		: " + ((Drink) coffee).temperature);
        System.out.println("6: ((Drink) espresso).getTemperature()	: " + ((Drink) espresso).getTemperature());
        System.out.println("7: Ist dieser Cast möglich? icedTea = (IcedTea)((Drink)coffee);");

    }
}