package Game;

import java.util.Scanner;
import java.util.Random;



public class Deadwood{

  public int die;

  public static void main(String[] args){
System.out.println("Welcome to Deadwood. The game of all games");
    int playerCount;
    Scanner pCount = new Scanner(System.in);
    System.out.println("Enter number of players");
    playerCount =  pCount.nextInt();
    int setDays = 0;
    int startCredits = 0;
    int startRank = 0;
    if(playerCount < 4) {
    setDays = 3;
    }else if(playerCount == 4) {
    setDays = 4;
    }else if (playerCount == 5) {
    setDays = 4;
    startCredits = 2;
    }else if (playerCount == 6) {
    setDays = 4;
    startCredits = 4;
    }else if (playerCount < 9) {
    setDays = 4;
    startRank = 2;
    } else {
    System.out.println("Too many players to player game");
    return;
    }

    String[] playerName = new String[playerCount];
    int i = 0;

    while (i < playerCount) {
    Scanner name = new Scanner(System.in);
    System.out.println("Please enter player " + (i + 1) + " name ");
    playerName[i] = name.nextLine();
    // playerName[i].Credits += startCredits;
    // playerName[i].Rank += startRank;
    //  set each player to location(0) at start;
    i++;
    }
    int rand_value = (int)(Math.random()*playerCount);
    System.out.println("ATTENTION ALL ACTORS. WELCOME TO THE STUDIO OF DEADWOOD");
    System.out.println("For the next " + setDays + " days, you all will be working set scenes trying to become the ULTIMATE ACTOR OF DEADWOOD");
    System.out.println("Best of luck to you all! p.s I've got money on you " + playerName[rand_value] + " so dont mess this up.");
    int j = 0;
    Board boardObject = new Board();
  //  boardObject.buildBoard();


    //String[playerCount][4] playerScores;




    Board game = new Board();
   // game.buildBoard();

    //while(dayCounter < setDays) {
    //outer loop that will go until day done
    //at end of loop:
    // dayCounter ++;
    // game.resetBoard();
  //}

    int dayCounter = 1;
    System.out.println("Day " + dayCounter + " has officaly begun!");

    //will be changed to while scene_num != 1 so each player will continue in this loop until only 1 scene left, then day resets and you go again.
    while(j < playerCount) {

    //get location and status of player to see if they are able to move or if they are in scene
    System.out.println(playerName[j] + " what would you like to do on your turn?");
    System.out.println("m for Move, w for Work?, u for upgrade, or nothing");
    Scanner turn_input = new Scanner(System.in);
    String choice = turn_input.nextLine();

    if(choice.equalsIgnoreCase("m")) {
    System.out.println("You choose to move!");
    System.out.println("Where would you like to go?");
    //playerName[j].location[3] should give players possible choices of location
    //scanner to read where they want to go.
    //add following options for what ever they choose to do after moving (taking role, upgrading, nothing)

    }else if(choice.equalsIgnoreCase("w")) {
    System.out.println("You choose to work! Do you want to be a star (s) or extra (e)?");
    Scanner acting_choice = new Scanner(System.in);
    String act_choice = acting_choice.nextLine();
    if(act_choice.equalsIgnoreCase("s")) {
    System.out.println("You choose to be a star babyyyy");
    System.out.println("Would you like to act (a) or rehearse (r)?");
        Scanner work_input = new Scanner(System.in);
        String work_choice = work_input.nextLine();

        if(work_choice.equalsIgnoreCase("a")) {
        System.out.println("You choose to act!");
           int die_num = roll();
           System.out.println("You rolled a " + die_num);

        } else if (work_choice.equalsIgnoreCase("r")) {
        System.out.println("You choose to Rehearse!");
        System.out.println("You gained a Practice Chip!");
        //practice chips added to player [i];

        } else {
        System.out.println("You didn't choose to act or rehearse, so we just will wait here");
        }
    }else if (act_choice.equalsIgnoreCase("e")) {
    System.out.println("You choose to be an extra ya dingus");
    System.out.println("Would you like to act (a) or rehearse (r)?");
        Scanner work_input = new Scanner(System.in);
        String work_choice = work_input.nextLine();

        if(work_choice.equalsIgnoreCase("a")) {
        System.out.println("You choose to act!");
           int die_num = roll();
           System.out.println("You rolled a " + die_num);

        } else if (work_choice.equalsIgnoreCase("r")) {
        System.out.println("You choose to Rehearse!");
        System.out.println("You gained a Practice Chip!");
        //practice chips added to player [i];

        } else {
        System.out.println("You didn't choose to act or rehearse, so we just will wait here");
        }
    }else {
    System.out.println("You didnt choose which role, so your nothin!");
    }
    }else if(choice.equalsIgnoreCase("u")) {
    System.out.println("You choose to upgrade.");
    //check to see if in upgrade room so can upgrade.
    //if is in room. give player credits to make decison to upgrade.
    //else
    System.out.println("Lol your not in the casting office silly");
    }
    else {
    System.out.println("You didnt choose to move or work so we stay at same location");
    }
    System.out.println("End of turn for " + playerName[j]);
    System.out.println("==========================");
    System.out.println();
    j++;
    }
    //reset board();

    //}


    //getScoreWinnner(playerScores);
   // getScoreWinnner(playerScores);

  }

  public static int roll(){
    return (int)(Math.random()*6) + 1;
  }


  //calculates each players total score and then compares for winner
  public static void getScoreWinnner(){
    //loop that takes first 3 values of each player and compares with others to see who is getScoreWinnner
    //return winner;
  }

}
