import java.util.Scanner;

/* Project for Module 1 in edX Java course
*  Travel Planner - calculates budget in destination's currency
*  Calculates time difference
*/


public class TripPlanner<moneySpent, conversion> {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        intro(input);
        gatherDetails(input);
        timeDifference(input);
    }

    // Welcome page, collects name and destination
    public static void intro(Scanner input) {
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String place = input.nextLine();
        System.out.println("Great! " + place + " sounds like a great trip");
        System.out.println("*************");
        System.out.println();
        System.out.println();
    }

    // Gathers details about currency and budget
    public static void gatherDetails(Scanner input) {
        System.out.print("How many days are you going to spend traveling? ");
        int daysTraveling = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int moneySpent = input.nextInt();
        System.out.print("What is the currency abbreviation for your destination? ");
        String moneyAbbreviation = input.next();
        System.out.print("How many " + moneyAbbreviation + " are there in 1 USD? ");
        double conversion = input.nextDouble();

        System.out.println("If you are travelling for "
                + daysTraveling + " days, that is the same as " + (daysTraveling*24) + " hours");
        System.out.println("If you're going to spend $"
                + moneySpent + " USD then your total budget is " + (int)(moneySpent*conversion)
                + " " + moneyAbbreviation);
    }

    // This calculates the time difference between home and destination (outputs 24hr time)
    public static void timeDifference(Scanner input) {
        System.out.print("What's the time difference between your home and destination? Use negative " +
                "numbers for time behind and positive for hours ahead: ");
        int hourDifference = input.nextInt();
        System.out.println("If it is midnight at home, it will be "
                + (hourDifference)%24 + ":00 at your destination");
    }
}
