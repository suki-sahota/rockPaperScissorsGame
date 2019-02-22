/*
 * Author: Suki Sahota
 * Description: Rock Paper Scissors Game
 */
import java.util.*;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        description();
        play();
        System.out.print("Do you want to play again? Type 'Yes' or 'No'");
        String fdecision = sc.nextLine();
        while (fdecision.equalsIgnoreCase("Yes")) {
            description();
            play();
            System.out.print("Do you want to play again? Type 'Yes' or 'No'");
            fdecision = sc.nextLine();
        }
        System.out.print("GOOD BYE. COME BACK SOON");
    }
    
    //this method describes the game
    public static void description() {
        System.out.println();
        System.out.println("Using this app you can play a Rock-Paper-Scissors game against your computer.");
    }
    
    //this method keeps track of wins/losses/ties
    public static void play() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int wins = 0, losses = 0, ties = 0;
        boolean playAgain = true;
        //while loop to control number of games
        while (playAgain) {
            String c = compChoice(rand);
            String u = userChoice(sc);
            if (u.equals("STOP")) {
                playAgain = false;
            }
            else if (c.equals("rock") && u.equals("PAPER")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                wins ++;
                System.out.println("Hurray! You won.");
            }
            else if (c.equals("rock") && u.equals("SCISSORS")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                losses ++;
                System.out.println("Oh No, you lost");
            }
            else if (c.equals("paper") && u.equals("SCISSORS")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                wins ++;
                System.out.println("Hurray! You won.");
            }
            else if (c.equals("paper") && u.equals("ROCK")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                losses ++;
                System.out.println("Oh No, you lost");
            }
            else if (c.equals("scissors") && u.equals("ROCK")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                wins ++;
                System.out.println("Hurray! You won.");
            }
            else if (c.equals("scissors") && u.equals("PAPER")) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                losses ++;
                System.out.println("Oh No, you lost");
            }
            else if ((c.equals("rock") && u.equals("ROCK")) || (c.equals("paper") && u.equals("PAPER")) || (c.equals("scissors") && u.equals("SCISSORS"))) {
                System.out.println("Computer selected: " + c + "\nYou selected: " + u);
                ties ++;
                System.out.println("There is a tie");
            }
        }
        //summary of game
        int played = wins + losses + ties;
        System.out.println("------------------------------------\nHere is the result of the play:\nTimes played: " + played + "\nWins:         " + wins);
        System.out.println("Losses:       " + losses);
        System.out.println("Ties:        " + ties);
        if (wins > losses) {
            System.out.println("Congratulations! You have a winning record.\n------------------------------------");
        }
        else if (wins < losses) {
            System.out.println("Sorry the computer has a winning record. Try again\n------------------------------------");
        }
        else {
            System.out.println("There is a tie.");
        }
        System.out.println("\n------------------------------------");
    }   
    
    //computer selection w/o if statements
    public static String compChoice(Random rand) {
        int comp = rand.nextInt(3);
        String c = "";
        switch (comp) {
            case 0: c = "Rock";
            break;
            case 1: c = "Paper";
            break;
            case 2: c = "Scissors";
            break;
            default: c = "Unknown";
            break;
        }
        return c.toLowerCase();
    }
    
    //user selection is made in this method
    public static String userChoice(Scanner sc) {
        System.out.println();
        System.out.print("Your choices are:\n\tRock\n\tPaper\n\tScissors\n\tstop\nEnter your choice: ");
        String uChoice = sc.next().toUpperCase();
        //while loop to validate user data
        while (!(uChoice.equalsIgnoreCase("ROCK") || uChoice.equalsIgnoreCase("PAPER") || uChoice.equalsIgnoreCase("SCISSORS") || uChoice.equalsIgnoreCase("STOP"))) {
            System.out.print("your choices\n\tRock\n\tPaper\n\tScissors\n\tstop\nEnter your choice: ");
            uChoice = sc.next().toUpperCase();
        }
        System.out.println();
        return uChoice;
    }
}