import java.util.*;
public class OddsAndEvens {

   /* public static final String USER_MODE = "even"; // default user selection is even
    public static final String USER_NAME = ""; // user name*/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\"");
        String userInfo = setup(input);
        play(input, userInfo);
    }

    public static String setup(Scanner input) {
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hello " + name + ", which do you choose? (O)dds or (E)vens? ");
        String mode = input.next();
        if (mode.startsWith("O")) {
            mode = "odds";
            System.out.println(name + " has picked " + mode + "! Computer will be evens");
        } else {
            mode = "evens";
            System.out.println(name + " has picked " + mode + "! Computer will be odds");
        }
        System.out.println("----------------------------");
        System.out.println();
        return mode + " " + name; // format for key info -> [odds/evens] [name]
    }

    // gets the numbers played by user and computer
    public static void play(Scanner input, String userInfo) {
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6); // generate random number 0 through 6 for computer
        System.out.println("Computer plays " + computer + " \"fingers\"");
        System.out.println("----------------------------");
        System.out.println();
        results(computer, fingers, userInfo);
    }

    // calculates who wins (if the sum is odd or even), declares winner
    public static void results(int computer, int fingers, String userInfo) {
        boolean oddOrEven = (computer + fingers) % 2 == 0; // true if even, false if odd
        System.out.println(computer + " + " + fingers + " = " + (computer + fingers)); // total sum
        String userName[] = userInfo.split(" "); // mode is userName[0] and name is userName[1]
        if (oddOrEven) { // if sum is even
            System.out.println((computer + fingers) + " is... " + "even!");
            if (userInfo.contains("evens")) { // if user chose "evens"
                System.out.println("That means " + userName[1] + " wins! :)");
            } else {
                System.out.println("That means the computer wins :(");
            }
        } else { // sum is odd
            System.out.println((computer + fingers + " is... " + "odd!"));
            if (userInfo.startsWith("odds")) { // if user chose "odds"
                System.out.println("That means " + userName[1] + " wins! :)");
            } else {
                System.out.println("That means the computer wins :(");
            }
        }
        System.out.println("----------------------------");
        System.out.println();
    }
}
