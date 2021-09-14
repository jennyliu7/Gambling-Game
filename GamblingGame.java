import java.util.*;

public class GamblingGame {
    public static void main(String [] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int sumPlayerOne = 0;
        int sumPlayerTwo = 0;
        int totalSumOne = 0; //total sum throughout the game
        int totalSumTwo = 0; //total sum throughout the game
        String yes = "yes";
        String no = "no";
        String instructRoll = "roll";

//INSTRUCTIONS
        System.out.println(" ");
        System.out.println("Welcome to the game of Pig!\n");
        System.out.println("First, please type player 1's name:");
        String playerOne = sc.next();
        System.out.println(" ");
        System.out.println("Next, please type player 2's name:");
        String playerTwo = sc.next();
        System.out.println(" ");
        System.out.println("Great, here's how to play: ");
        System.out.println("- To start your turn, type your name.");
        System.out.println("- Next, to roll your die, type \"roll\"");
        System.out.println("- If you roll a 1, your turn is over, and you lose all your points from that turn.");
        System.out.println("- If you want to end your turn, please type \"stop\".");
        System.out.println("- To switch players, the next player will first type their name to begin their turn and then type \"roll\" to roll their die.\n");
        System.out.println("Let's begin! Who is going first?");

//PLAYER ONE
        while(totalSumOne<50 && totalSumTwo<50) {
            String name = sc.next();
            if (name.equals(playerOne)) {
                sumPlayerOne = 0; //sum after each turn
                int roll = 0;
                System.out.print("type \"roll\" to roll your die\n");
                for (int i= 0; sc.next().equals(instructRoll); i++) {
                    roll = (rand.nextInt(6) +1);
                    System.out.println("you rolled a: " +roll);
                    if (roll!= 1) { //if you don't roll a one
                        sumPlayerOne += roll;
                        System.out.println("your sum so far is: " +sumPlayerOne);
                        System.out.println(" ");
                        System.out.println("do you want to keep going? (type \"yes\" or \"no\")");
                        String yesOrNo = sc.next();
                        if (yesOrNo.equals(no)) { //player wants to stop
                            totalSumOne += sumPlayerOne;
                            if (totalSumOne>=50) {
                                System.out.println("Congratulations " +playerOne +"! You are the winner!");
                                System.exit(0);
                            }
                            wantStop(playerOne, playerTwo, sumPlayerOne, totalSumOne, totalSumTwo);
                            break;
                        } else if (yesOrNo.equals(yes))  {
                            System.out.print("type \"roll\" to roll when you're ready to test your luck.\n");
                        } else {
                            throw new IllegalArgumentException("answer can only be \"yes\" or \"no\"");
                        }
                    } else { //if you roll a one
                        sumPlayerOne = 0;
                        rolled1(playerOne, playerTwo, sumPlayerOne, totalSumOne, totalSumTwo);
                        break;
                    }
                }
//PLAYER TWO
            } else if (name.equals(playerTwo)) {
                sumPlayerTwo = 0; //sum after each turn
                int roll = 0;
                System.out.print("type \"roll\" to roll your die\n");
                for (int i= 0; sc.next().equals(instructRoll); i++) {
                    roll = (rand.nextInt(6) +1);
                    System.out.println("you rolled a: " +roll);
                    if (roll!= 1) { //if you don't roll a one
                        sumPlayerTwo += roll;
                        System.out.println("your sum so far is: " +sumPlayerTwo);
                        System.out.println(" ");
                        System.out.println("do you want to stop your turn now? (type \"yes\" or \"no\")");
                        String yesOrNo = sc.next();
                        if (yesOrNo.equals(yes)) { //player wants to stop
                            totalSumTwo += sumPlayerTwo;
                            if (totalSumTwo>=50) {
                                System.out.println("Congratulations " +playerTwo +"! You are the winner!");
                                System.exit(0);
                            }
                            wantStop(playerTwo, playerOne, sumPlayerTwo, totalSumTwo, totalSumOne);
                            break;
                        } else if (yesOrNo.equals(no))  {
                            System.out.print("type \"roll\" to roll again\n");
                        } else {
                            throw new IllegalArgumentException("answer can only be \"yes\" or \"no\"");
                        }
                    } else { //if you roll a one
                        sumPlayerTwo = 0;
                        rolled1(playerTwo, playerOne, sumPlayerTwo, totalSumTwo, totalSumOne);
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException("you must type your name first and then type \"roll\" when prompted to do so");
            }
        } //end of while loop
    } //end of main

    public static void rolled1 (String a, String b, int sumCurrent, int totalCurrent, int totalOther) {
        System.out.println(" ");
        System.out.println("you rolled a 1, so your turn is over");
        System.out.println(a+ "'s score for this round is: " +sumCurrent);
        System.out.println(a +"'s total score is: " +totalCurrent);
        System.out.println("(" +b +"'s total score is: " +totalOther +")");
        System.out.println("SWITCH TURNS (the next player will type their name first)\n");
    }

    public static void wantStop (String a, String b, int sumCurrent, int totalCurrent, int totalOther) {
        System.out.println(" ");
        System.out.println("your turn is over");
        System.out.println(a +"'s score for this round is: " +sumCurrent);
        System.out.println(a +"'s total score is: " +totalCurrent);
        System.out.println("(" +b +"'s total score is: " +totalOther +")");
        System.out.println("SWITCH TURNS (the next player will type their name first)\n");
    }
}