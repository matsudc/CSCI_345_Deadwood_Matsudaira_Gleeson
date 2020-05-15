package Game;

//import Game.Player;
//import Game.Board;

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
    startRank = 1;
    } else {
    System.out.println("Too many players to player game");
    return;
    }

    String[] playerName = new String[playerCount];
    int i = 0;

    Player playerstat = new Player();
    int playerCredits = 0;

    while (i < playerCount) {
    Scanner name = new Scanner(System.in);
    System.out.println("Please enter player " + (i + 1) + " name ");
    playerName[i] = name.nextLine();
        playerstat.Player(playerName[i]);
        //set up each players starting credits
        if(startCredits > 0) {
       for(int k = 0; k < startCredits; k++) {
        playerstat.increaseCredits();
       }
        }
        //set up each players starting credits
        if(startRank == 1) {
        playerstat.increaseRank();
       }
    // Each player automatically starts at location 0 (Trailer)
    i++;
    }
    //BEGINNING SPEECH
  //  int rand_value = (int)(Math.random()*playerCount);
  //  System.out.println("ATTENTION ALL ACTORS. WELCOME TO THE STUDIO OF DEADWOOD");
  //  System.out.println("For the next " + setDays + " days, you all will be working set scenes trying to become the ULTIMATE ACTOR OF DEADWOOD");
  //  System.out.println("Best of luck to you all! p.s I've got money on you " + playerName[rand_value] + " so dont mess this up.");



//    int rank = playerstat.getRank(playerName[0]);
//    int cred = playerstat.getcredits(playerName[0]);
//    int location = playerstat.getLocation(playerName[0]);
//    System.out.println("This is rank of " + playerName[0] + (" ") + rank);
//    System.out.println("This is credits of " + playerName[0] + (" ") + cred);
//    System.out.println("This is location of " + playerName[0] + (" ") + location);




    //while(dayCounter < setDays) {
    //outer loop that will go until day done
    //at end of loop:
    // dayCounter ++;
    // game.resetBoard();
  //}

    int dayCounter = 1;
    System.out.println("Day " + dayCounter + " has officaly begun!");
    int j = 0;

    Board boardloc = new Board();


    //will be changed to while scene_num != 1 so each player will continue in this loop until only 1 scene left, then day resets and you go again.
    while(j < playerCount) {
    int location = playerstat.getLocation(playerName[j]);
    int cred = playerstat.getcredits(playerName[j]);
    int rank = playerstat.getRank(playerName[j]);


    //get location and status of player to see if they are able to move or if they are in scene
    System.out.println(playerName[j] + " you are at location " + location + ". What would you like to do on your turn?");
    System.out.println("m for Move, w for Work?, u for upgrade, or nothing");
    Scanner turn_input = new Scanner(System.in);
    String choice = turn_input.nextLine();

    if(choice.equalsIgnoreCase("m")) {
    System.out.println("You choose to move!");
    System.out.println("Where would you like to go?");


    int moves[] = boardloc.moveCount(location);
    int x = 0;
    while(x < moves.length) {
    boardloc.buildBoard(moves[x], 2);
    if(x + 1 != moves.length) {
    System.out.print(" or ");
    }
    x++;
    }
    System.out.println(" ");
        Scanner move_input = new Scanner(System.in);
        String move_choice = move_input.nextLine();
        if(moves.length == 3) {
        if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[0]));
        playerstat.updateLocation(playerName[j], moves[0]);
        }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[1]));

        playerstat.updateLocation(playerName[j], moves[1]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[2]));
        playerstat.updateLocation(playerName[j], moves[2]);
        }else {
        System.out.println("Not a location available to go to");
        }
        } else { //move length is 4
        if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[0]));
        playerstat.updateLocation(playerName[j], moves[0]);
        }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[1]));
        playerstat.updateLocation(playerName[j], moves[1]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[2]));
        playerstat.updateLocation(playerName[j], moves[2]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[3]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[3]));
        playerstat.updateLocation(playerName[j], moves[3]);
        } else {
        System.out.println("Not a location available to go to");
        }
        }
    // System.out.println("You can move to " + boardloc.buildBoard(0, parameter))

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
