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
    if(playerCount < 4 && playerCount != 1) {
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
   
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();
    Player player5 = new Player();
    Player player6 = new Player();
    Player player7 = new Player();
    Player player8 = new Player();
    Player[] players = new Player[] {player1, player2, player3, player4, player5, player6, player7, player8};
    Player [] playersReal = new Player[playerCount];
   
    for(int k = 0; k < playerCount; k++) {
    playersReal[k] = players[k];
    }
   
   
    while (i < playerCount) {
    Scanner name = new Scanner(System.in);
    System.out.println("Please enter player " + (i + 1) + " name ");
    playerName[i] = name.nextLine();
        playersReal[i].Player(playerName[i]);
        if(startCredits > 0) {
        playersReal[i].increaseCredits(startCredits);
        }
   //set up each players starting credits
   if(startRank == 2) {
    playersReal[i].updateRank(startRank);
  }    
    i++;
    }

   
   
    //BEGINNING SPEECH
  //  int rand_value = (int)(Math.random()*playerCount);
  //  System.out.println("ATTENTION ALL ACTORS. WELCOME TO THE STUDIO OF DEADWOOD");
  //  System.out.println("For the next " + setDays + " days, you all will be working set scenes trying to become the ULTIMATE ACTOR OF DEADWOOD");
  //  System.out.println("Best of luck to you all! p.s I've got money on you " + playerName[rand_value] + " so dont mess this up.");
   
 
   
    int dayCounter = 1;  
    System.out.println("Day " + dayCounter + " has officaly begun!");

   
    Board boardloc = new Board();
    int location;
    int cred;
    int rank;
    int dolla;

    //will be changed to while scene_num != 1 so each player will continue in this loop until only 1 scene left, then day resets and you go again.
    int scene_count = 10;
    //while(while daycounter != set days)
    //while scene_num != 1
    while(scene_count != 1) {
        int j = 0;
   while(j < playerCount) {    
    location = playersReal[j].getLocation(playerName[j]);

String current_location = null;
   
  // System.out.println("This is location variable value: " + location);
  // System.out.println("This is location class value " + playerstat.getLocation(playerName[j]));
  // System.out.println("This is " + playerName[j] + " practice chip count: " + playerstat.getPractice(playerName[j]) );
  // System.out.println("This is " + playerName[j] + " rank count: " + playerstat.getRank(playerName[j]) );
  // System.out.println("This is " + playerName[j] + " credit count: " + playerstat.getcredits (playerName[j]) );
   
    //NOTE: get location and status of player to see if they are able to move or if they are in scene
   
    System.out.println(playerName[j] + " you are at the " + boardloc.locationName(location) + ". What would you like to do on your turn?");
    System.out.println("m for Move, w for Work?, u for upgrade, or nothing");
    Scanner turn_input = new Scanner(System.in);
    String choice = turn_input.nextLine();
   
   
    //Moving clause:
    if(choice.equalsIgnoreCase("m")) {
    System.out.println("You choose to move!");
    System.out.println("Where would you like to go?");

   
    int moves[] = boardloc.moveCount(location);
    int x = 0;
    while(x < moves.length) {
    boardloc.printName(moves[x]);
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
        playersReal[j].updateLocation(playerName[j], moves[0]);
        current_location = boardloc.locationName(moves[0]);
        }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[1]));      
        playersReal[j].updateLocation(playerName[j], moves[1]);
        current_location = boardloc.locationName(moves[1]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[2]));
        playersReal[j].updateLocation(playerName[j], moves[2]);
        current_location = boardloc.locationName(moves[2]);
        }else {
        System.out.println("Not a location available to go to");
        }
        } else { //move length is 4
        if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[0]));
        playersReal[j].updateLocation(playerName[j], moves[0]);
        current_location = boardloc.locationName(moves[0]);
        }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[1]));
        playersReal[j].updateLocation(playerName[j], moves[1]);
        current_location = boardloc.locationName(moves[1]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[2]));
        playersReal[j].updateLocation(playerName[j], moves[2]);
        current_location = boardloc.locationName(moves[2]);
        }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[3]))) {
        System.out.println("You moved to " + boardloc.locationName(moves[3]));
        playersReal[j].updateLocation(playerName[j], moves[3]);
        current_location = boardloc.locationName(moves[3]);
        } else {
        System.out.println("Not a location available to go to");
        }        
        }
       
        //What to do past moving:
        if(current_location.equalsIgnoreCase("casting")) {
        playersReal[j].upgrade();
        }else if(current_location != "trailer") {
        System.out.println("You are currently at " + current_location);
       
       
        //check to see if scenes available on set
        //check to see if wants to take a role
       
       
        }else {
        System.out.println("You end up back in the trailer");
        }
       
       
    }else if(choice.equalsIgnoreCase("w")) {
    //check to see if in a scene able to work:
    int location_value = playersReal[j].getLocation(playerName[j]);
    current_location = boardloc.locationName(location_value);
    if(current_location.equalsIgnoreCase("casting")) {
    System.out.println("You are not able to work when at the " + current_location);
    }else if(current_location.equalsIgnoreCase("trailer")) {
    System.out.println("You are not able to work when at the " + current_location);
    }else {
   
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
        playersReal[j].increasePractice();
            System.out.println("This is " + playerName[j] + " practice chip count: " + playersReal[j].getPractice());
       
        } else {
        System.out.println("You didn't choose to act or rehearse, so we just will wait here");
        }
    }else if (act_choice.equalsIgnoreCase("e")) {
    System.out.println("You choose to be an extra");
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
        playersReal[j].increasePractice();
            System.out.println("This is " + playerName[j] + " practice chip count: " + playersReal[j].getPractice());
       
        } else {
        System.out.println("You didn't choose to act or rehearse, so your turn has ended");
        }
    }else {
    System.out.println("You didnt choose which role, so your nothin!");
    }
    }
    }else if(choice.equalsIgnoreCase("u")) {
    System.out.println("You choose to upgrade.");
    int location_value = playersReal[j].getLocation(playerName[j]);
    current_location = boardloc.locationName(location_value);
    if(current_location.equalsIgnoreCase("casting")) {
    playersReal[j].upgrade();
    }else {
    System.out.println("Not able to upgrade, not in casting office");
    }
    //check to see if in upgrade room so can upgrade.
    }
    else {
    System.out.println("You didnt choose to move or work so we stay at same location");
    }
    System.out.println("End of turn for " + playerName[j]);
    System.out.println("==========================");
    System.out.println();
    j++;
   }
   scene_count--;
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