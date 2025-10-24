public class App {
    public static void main(String[] args)  {

        TurtleBot bot1 = new TurtleBot(0,0,0);
        TurtleBot bot2 = new TurtleBot(100,50,75);

        Drone drone1 = new Drone(10,75,90);
        Drone drone2 = new Drone(14,30,420);

        bot1.bringup();
        bot2.bringup();
        System.out.println();
        drone1.bringup();
        drone2.bringup();
        System.out.println();

        // Simulation nach vorne fahren und fliegen
        bot1.driveForward(10);
        bot2.driveForward(25);
        System.out.println();   
        drone1.flyForward(15);
        drone2.flyForward(20);

    }
}
