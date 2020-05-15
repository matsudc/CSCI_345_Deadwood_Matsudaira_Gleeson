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
    startRank = 1;
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
        playersReal[i].increaseCredits(startCredits, playerName[i]);
        }
   //set up each players starting credits
   if(startRank == 1) {
    playersReal[i].increaseRank(startRank, playerName[i]);
  }    
    i++;
    }

   
   
    //BEGINNING SPEECH
  //  int rand_value = (int)(Math.random()*playerCount);
  //  System.out.println("ATTENTION ALL ACTORS. WELCOME TO THE STUDIO OF DEADWOOD");
  //  System.out.println("For the next " + setDays + " days, you all will be working set scenes trying to become the ULTIMATE ACTOR OF DEADWOOD");
  //  System.out.println("Best of luck to you all! p.s I've got money on you " + playerName[rand_value] + " so dont mess this up.");
   
 




 
   
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
    int location;
    int cred;
    int rank;
    int dolla;

    //will be changed to while scene_num != 1 so each player will continue in this loop until only 1 scene left, then day resets and you go again.
    int p = 0;
    //while(while daycounter != set days)
    //while scene_num != 1
    while(p < 4) {
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
    boardloc.printName(moves[x], 2);
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
        if(current_location == "casting") {
        System.out.println("Welcome to the casting office!");
        System.out.println("You can upgrade your rank using Dollars or Credits!");
        System.out.println("Rank 2 requires either 4 dollars or 5 credits");
        System.out.println("Rank 3 requires either 10 dollars or 10 credits");
        System.out.println("Rank 4 requires either 18 dollars or 15 credits");
        System.out.println("Rank 5 requires either 28 dollars or 20 credits");
        System.out.println("Rank 6 requires either 40 dollars or 25 credits");
        System.out.println(playerName[j] + ", you currently are rank " + playersReal[j].getRank(playerName[j]) + " with "
        + playersReal[j].getcredits(playerName[j]) + " credits and " + playersReal[j].getDollars(playerName[j]));
        System.out.println("So would you like to upgrade your rank?");
        System.out.println("Yes (y) or No (n)?");
        Scanner upgrade_input = new Scanner(System.in);
            String upgrade_choice = upgrade_input.nextLine();
            if(upgrade_choice.equalsIgnoreCase("y")) {
           
            System.out.println("Will you use Credits (c) or Dollars (d)?");
            Scanner upgrade_wealth_input = new Scanner(System.in);
                String upgrade_wealth_choice = upgrade_wealth_input.nextLine();
                if(upgrade_wealth_choice.equalsIgnoreCase("c")) {
                if(playersReal[j].getcredits(playerName[j]) < 5) {
                System.out.println("You dont have enough credits to upgrade, sorry");
                }else if (playersReal[j].getcredits(playerName[j]) < 10) {
                System.out.println("You can upgrade to rank 2 only");
                if(playersReal[j].getRank(playerName[j]) >= 2) {
                System.out.println("However, you are already at rank " + playersReal[j].getRank(playerName[j]) + " and cant down grade rank");
                }else {
                System.out.println("Continue upgrading to rank 2? Yes (y) or no (n) ");
                        Scanner upgrade_decision_input = new Scanner(System.in);
                            String upgrade_decision = upgrade_decision_input.nextLine();
                            if(upgrade_decision.equalsIgnoreCase("y")) {
                           
                            }
                }
                }
                }else if (upgrade_wealth_choice.equalsIgnoreCase("c")) {
                dolla = playersReal[j].getDollars(playerName[j]);
                //choose to use dollars. check to see if they can upgrade.
                }else {
                System.out.println("Failed to choose either option...");
                }
               
            }else {
            System.out.println("Oh well, hopefully you can upgrade next time!");
            }      
        }else if(current_location != "trailer") {
        System.out.println("You are currently at " + current_location);
       
       
        //check to see if scenes available on set
        //check to see if wants to take a role
       
       
        }else {
        System.out.println("You end up back in the trailer");
        }
       
       
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
        playersReal[j].increasePractice(playerName[j]);
            System.out.println("This is " + playerName[j] + " practice chip count: " + playersReal[j].getPractice(playerName[j]));
       
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
        playersReal[j].increasePractice(playerName[j]);
            System.out.println("This is " + playerName[j] + " practice chip count: " + playersReal[j].getPractice(playerName[j]));
       
        } else {
        System.out.println("You didn't choose to act or rehearse, so your turn has ended");
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
   p++;
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
