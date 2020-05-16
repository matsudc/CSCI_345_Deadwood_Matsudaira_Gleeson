package Game;

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;



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
   
 //   String[] playerName = new String[playerCount];
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
    String[] arr = new String[] {"blue", "cyan", "green", "orange", "pink", "red", "violet", "yellow"};
    String[] color_array = new String[playerCount];
    Player [] playersReal = new Player[playerCount];
   
    for(int k = 0; k < playerCount; k++) {
    color_array[k] = arr[k];
    playersReal[k] = players[k];
    }

   
    while (i < playerCount) {
   // Scanner name = new Scanner(System.in);
   // System.out.println("Please enter player " + (i + 1) + " name ");
   // playerName[i] = name.nextLine();
        playersReal[i].Player(color_array[i]);
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
  //  System.out.println("Best of luck to you all! p.s I've got money on you " + color_array[rand_value] + " so dont mess this up.");
   
 
   
    int dayCounter = 1;  
    System.out.println("Day " + dayCounter + " has officaly begun!");

   
    Board boardloc = new Board();
    int location;
    int cred;
    int rank;
    int dolla;
   
    boolean next = false;
    //Board newBoard = new Board();
    HashMap<Location, Scene> board = new HashMap<Location,Scene>();

    //will be changed to while scene_num != 1 so each player will continue in this loop until only 1 scene left, then day resets and you go again.
    int scene_count = 10;
    //while(while daycounter != set days)
   
   
    while (dayCounter != setDays) {  
   if (!next) {
    //board = newBoard.buildBoard();
	   board = boardloc.buildBoard();
   } else {
    //board = newBoard.resetBoard();
	   board = boardloc.resetBoard();
   }
   while(scene_count != 1) {
      int j = 0;
      while(j < playerCount) {    
      location = playersReal[j].getLocation();
      boolean turn_check = false;
      String current_location = null;
//       System.out.println("This is " + color_array[j] + " practice chip count: " + playersReal[j].getPractice());
//       System.out.println("This is " + color_array[j] + " rank count: " + playersReal[j].getRank() );
//       System.out.println("This is " + color_array[j] + " credit count: " + playersReal[j].getcredits ());
     
       //NOTE: get location and status of player to see if they are able to move or if they are in scene
     
       System.out.println(color_array[j] + " you are at the " + boardloc.locationName(location) + ". What would you like to do on your turn?");
       
       if(boardloc.locationName(location).equalsIgnoreCase("Trailer")) { //PLAYER LOCATION AT TRAILER
       System.out.println("You can Move (m) or do Nothing (n)");
       while(turn_check == false) {
       Scanner turn_input = new Scanner(System.in);
       String choice = turn_input.nextLine();
       if(choice.equalsIgnoreCase("n")) { //Player choose to do nothing
        turn_check = true;
        j++;
       }else if(choice.equalsIgnoreCase("m")) { //PLayer choose to move
        turn_check = true;
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
       boolean move_check = false;
       while(move_check == false) {
           Scanner move_input = new Scanner(System.in);
           String move_choice = move_input.nextLine();
           if(moves.length == 3) {
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));      
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else {
            System.out.println("Not a location available to go to, Try again");
           }
           } else { //move length is 4
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[3]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[3]));
            playersReal[j].updateLocation(color_array[j], moves[3]);
            current_location = boardloc.locationName(moves[3]);
           } else {
            System.out.println("Not a location available to go to, Try again");
           }        
           }
       }
         
           //What to do past moving:
           if(current_location.equalsIgnoreCase("casting")) { //player moved to upgrade
            playersReal[j].upgrade();
           }else if(current_location.equalsIgnoreCase("trailer")) { //player is at trailer (somehow)
            System.out.println("You are currently at " + current_location);          
           }else {
            System.out.println("You are on a set"); //You moved to a set
           //check to see if scenes available on set
           
           //check to see if wants to take a role
            
            Location playerLoc = boardloc.getLocation(playersReal[j].getLocation());
            Scene locScene = board.get(playerLoc);
            
//            System.out.println(playerLoc.getName());
//            System.out.println(locScene.getName());
            
            int[] locRole = playerLoc.getRoles();
            int[] sceneRole = locScene.sceneRoles();
            
            System.out.println("Would you like to take a role? y/n");
            Scanner inputRole = new Scanner(System.in);
            String takerole = inputRole.nextLine();
            
            if (takerole.equalsIgnoreCase("y")) {
            	
            	System.out.println("Would you like an on card role? y/n");
            	Scanner inputCard = new Scanner(System.in);
            	String cardRole = inputCard.nextLine();
            	
            	System.out.println("Your rank is " + playersReal[j].getRank());
            	
            	if (cardRole.equalsIgnoreCase("y")) {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these on card roles.");
            			System.out.println(Arrays.toString(sceneRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < sceneRole.length; q++) {
            					if (chooseRole == sceneRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole <= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, true);
            					valid = true;
            				} else {
            					System.out.println("Please choose a valid role.");
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid role. Did you change your mind? y/n");
            				Scanner newAnswer = new Scanner(System.in);
            				String nextAnswer = newAnswer.nextLine();
            				
            				if (nextAnswer.equalsIgnoreCase("y")) {
            					System.out.println("You did not take a role.");
            					break;
            				}
            			}
            		}
            		
            		
            		
            	} else {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these off card roles.");
            			System.out.println(Arrays.toString(locRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < locRole.length; q++) {
            					if (chooseRole == locRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole >= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, false);
            					valid = true;
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid choice.");
            			}
            		}
            	}
            	
            } else {
            	System.out.println("You did not take a role.");
            }
           }
       }else {
        System.out.println("Must choose either m or n");
       }
       }
        //PLAYER IS AT CASTING OFFICE    
       }else if (boardloc.locationName(location).equalsIgnoreCase("Casting")) {
        System.out.println("You can Move (m) or Upgrade (u) or do Nothing (n)");
       while(turn_check == false) {
       Scanner turn_input = new Scanner(System.in);
       String choice = turn_input.nextLine();
       if(choice.equalsIgnoreCase("n")) { //PLayer choose to do nothing
        turn_check = true;
        j++;
       }else if(choice.equalsIgnoreCase("m")) { //Player choose to MOVE
        turn_check = true;
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
       boolean move_check = false;
       while(move_check == false) {
           Scanner move_input = new Scanner(System.in);
           String move_choice = move_input.nextLine();
           if(moves.length == 3) {
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));      
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else {
            System.out.println("Not a location available to go to, Try again");
           }
           } else { //move length is 4
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[3]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[3]));
            playersReal[j].updateLocation(color_array[j], moves[3]);
            current_location = boardloc.locationName(moves[3]);
           } else {
            System.out.println("Not a location available to go to, Try again");
           }        
           }
       }          
           //What to do past moving:
           if(current_location.equalsIgnoreCase("casting")) { //player moved to upgrade
            playersReal[j].upgrade();
           }else if(current_location.equalsIgnoreCase("trailer")) { //player is at trailer (somehow)
            System.out.println("You are currently at " + current_location);          
           }else {
            System.out.println("You are on a set"); //You moved to a set
           //check to see if scenes available on set
           
           //check to see if wants to take a role
            
            Location playerLoc = boardloc.getLocation(playersReal[j].getLocation());
            Scene locScene = board.get(playerLoc);
            
//            System.out.println(playerLoc.getName());
//            System.out.println(locScene.getName());
            
            int[] locRole = playerLoc.getRoles();
            int[] sceneRole = locScene.sceneRoles();
            
            System.out.println("Would you like to take a role? y/n");
            Scanner inputRole = new Scanner(System.in);
            String takerole = inputRole.nextLine();
            
            if (takerole.equalsIgnoreCase("y")) {
            	
            	System.out.println("Would you like an on card role? y/n");
            	Scanner inputCard = new Scanner(System.in);
            	String cardRole = inputCard.nextLine();
            	
            	System.out.println("Your rank is " + playersReal[j].getRank());
            	
            	if (cardRole.equalsIgnoreCase("y")) {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these on card roles.");
            			System.out.println(Arrays.toString(sceneRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < sceneRole.length; q++) {
            					if (chooseRole == sceneRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole <= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, true);
            					valid = true;
            				} else {
            					System.out.println("Please choose a valid role.");
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid role. Did you change your mind? y/n");
            				Scanner newAnswer = new Scanner(System.in);
            				String nextAnswer = newAnswer.nextLine();
            				
            				if (nextAnswer.equalsIgnoreCase("y")) {
            					System.out.println("You did not take a role.");
            					break;
            				}
            			}
            		}
            		
            		
            		
            	} else {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these off card roles.");
            			System.out.println(Arrays.toString(locRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < locRole.length; q++) {
            					if (chooseRole == locRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole >= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, false);
            					valid = true;
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid choice.");
            			}
            		}
            	}
            	
            } else {
            	System.out.println("You did not take a role.");
            }
           }
       }else if (choice.equalsIgnoreCase("u")) { //PLayer choose to upgrade
        turn_check = true;
        playersReal[j].upgrade();
       }else {
        System.out.println("Must choose m, u, or n");
       }        
       }
       
        //PLAYER ON A SET
       }else {
        //PLayer doesn't have a role
        if(playersReal[j].roleRank == -1) {
       System.out.println("You can Move(m), Work(w) or Nothing(n)");
       while(turn_check == false) {
       Scanner turn_input = new Scanner(System.in);
       String choice = turn_input.nextLine();
       if(choice.equalsIgnoreCase("n")) { //PLayer choose to do nothing
        turn_check = true;
        j++;
       }else if(choice.equalsIgnoreCase("m")) { //PLayer choose to move
        turn_check = true;
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
       boolean move_check = false;
       while(move_check == false) {
           Scanner move_input = new Scanner(System.in);
           String move_choice = move_input.nextLine();
           if(moves.length == 3) {
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));      
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else {
            System.out.println("Not a location available to go to, Try again");
           }
           } else { //move length is 4
           if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[0]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[0]));
            playersReal[j].updateLocation(color_array[j], moves[0]);
            current_location = boardloc.locationName(moves[0]);
           }else if(move_choice.equalsIgnoreCase(boardloc.locationName(moves[1]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[1]));
            playersReal[j].updateLocation(color_array[j], moves[1]);
            current_location = boardloc.locationName(moves[1]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[2]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[2]));
            playersReal[j].updateLocation(color_array[j], moves[2]);
            current_location = boardloc.locationName(moves[2]);
           }else if (move_choice.equalsIgnoreCase(boardloc.locationName(moves[3]))) {
            move_check = true;
            System.out.println("You moved to " + boardloc.locationName(moves[3]));
            playersReal[j].updateLocation(color_array[j], moves[3]);
            current_location = boardloc.locationName(moves[3]);
           } else {
            System.out.println("Not a location available to go to, Try again");
           }        
           }
       }          
           //What to do past moving:
           if(current_location.equalsIgnoreCase("casting")) { //player moved to upgrade
            playersReal[j].upgrade();
           }else if(current_location.equalsIgnoreCase("trailer")) { //player is at trailer (somehow)
            System.out.println("You are currently at " + current_location);          
           }else {
            System.out.println("You are on a set"); //You moved to a set
           //check to see if scenes available on set
           
           //check to see if wants to take a role
            
            Location playerLoc = boardloc.getLocation(playersReal[j].getLocation());
            Scene locScene = board.get(playerLoc);
            
            int[] locRole = playerLoc.getRoles();
            int[] sceneRole = locScene.sceneRoles();
            
            System.out.println("Would you like to take a role? y/n");
            Scanner inputRole = new Scanner(System.in);
            String takerole = inputRole.nextLine();
            
            if (takerole.equalsIgnoreCase("y")) {
            	
            	System.out.println("Would you like an on card role? y/n");
            	Scanner inputCard = new Scanner(System.in);
            	String cardRole = inputCard.nextLine();
            	
            	System.out.println("Your rank is " + playersReal[j].getRank());
            	
            	if (cardRole.equalsIgnoreCase("y")) {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these on card roles.");
            			System.out.println(Arrays.toString(sceneRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < sceneRole.length; q++) {
            					if (chooseRole == sceneRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole >= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, true);
            					valid = true;
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid role");
            			}
            		}
            		
            		
            		
            	} else {
            		
            		boolean valid = false;
            		
            		while(!valid) {
            			
            			System.out.println("Pick one of these off card roles.");
            			System.out.println(Arrays.toString(locRole));
            			
            			Scanner roleChoose = new Scanner(System.in);
            			String roleChoice = roleChoose.nextLine();
            			
            			try {
            				int chooseRole = Integer.parseInt(roleChoice);
            				
            				boolean inRole = false;
            				
            				for(int q = 0; q < locRole.length; q++) {
            					if (chooseRole == locRole[q]) {
            						inRole = true;
            						break;
            					}
            				}
            				
            				if (chooseRole >= playersReal[j].getRank() && inRole) {
            					System.out.println("You now have this role.");
            					playersReal[j].takeRole(chooseRole, false);
            					valid = true;
            				}
            			} catch (Exception e) {
            				System.out.println("Not a valid choice.");
            			}
            		}
            	}
            	
            } else {
            	System.out.println("You did not take a role.");
            }
           }
       }else if (choice.equalsIgnoreCase("w")) { //PLayer Choose to work
        turn_check = true;
        //takes role at set at current location.
        System.out.println("You choose to work on the set");
        System.out.println("You do not have a role.");
        
      //check to see if scenes available on set
        
        //check to see if wants to take a role
         
         Location playerLoc = boardloc.getLocation(playersReal[j].getLocation());
         Scene locScene = board.get(playerLoc);
         
         int[] locRole = playerLoc.getRoles();
         int[] sceneRole = locScene.sceneRoles();
         
         System.out.println("Would you like to take a role? y/n");
         Scanner inputRole = new Scanner(System.in);
         String takerole = inputRole.nextLine();
         
         if (takerole.equalsIgnoreCase("y")) {
         	
         	System.out.println("Would you like an on card role? y/n");
         	Scanner inputCard = new Scanner(System.in);
         	String cardRole = inputCard.nextLine();
         	
         	System.out.println("Your rank is " + playersReal[j].getRank());
         	
         	if (cardRole.equalsIgnoreCase("y")) {
         		
         		boolean valid = false;
         		
         		while(!valid) {
         			
         			System.out.println("Pick one of these on card roles.");
         			System.out.println(Arrays.toString(sceneRole));
         			
         			Scanner roleChoose = new Scanner(System.in);
         			String roleChoice = roleChoose.nextLine();
         			
         			try {
         				int chooseRole = Integer.parseInt(roleChoice);
         				
         				boolean inRole = false;
         				
         				for(int q = 0; q < sceneRole.length; q++) {
         					if (chooseRole == sceneRole[q]) {
         						inRole = true;
         						break;
         					}
         				}
         				
         				if (chooseRole >= playersReal[j].getRank() && inRole) {
         					System.out.println("You now have this role.");
         					playersReal[j].takeRole(chooseRole, true);
         					valid = true;
         				}
         			} catch (Exception e) {
         				System.out.println("Not a valid role");
         			}
         		}
         		
         		
         		
         	} else {
         		
         		boolean valid = false;
         		
         		while(!valid) {
         			
         			System.out.println("Pick one of these off card roles.");
         			System.out.println(Arrays.toString(locRole));
         			
         			Scanner roleChoose = new Scanner(System.in);
         			String roleChoice = roleChoose.nextLine();
         			
         			try {
         				int chooseRole = Integer.parseInt(roleChoice);
         				
         				boolean inRole = false;
         				
         				for(int q = 0; q < locRole.length; q++) {
         					if (chooseRole == locRole[q]) {
         						inRole = true;
         						break;
         					}
         				}
         				
         				if (chooseRole >= playersReal[j].getRank() && inRole) {
         					System.out.println("You now have this role.");
         					playersReal[j].takeRole(chooseRole, false);
         					valid = true;
         				}
         			} catch (Exception e) {
         				System.out.println("Not a valid choice.");
         			}
         		}
         	}
         	
         } else {
         	System.out.println("You did not take a role.");
         	break;
         }
        
        int location_value = playersReal[j].getLocation();
    	current_location = boardloc.locationName(location_value);
    
    
//        Location playerLoc = boardloc.getLocation(location_value);
//    	Scene locScene = board.get(playerLoc);
//    
//    	int[] locRole = playerLoc.getRoles();
//        int[] sceneRole = locScene.sceneRoles();
    
    	int shot = playerLoc.getShot();
    	boolean onCard = playersReal[j].getCard();
        
        if(playersReal[j].getRoleRank() >0) {
        	System.out.println("Would you like an on card role? y/n");
        	Scanner inputCard = new Scanner(System.in);
        	String cardRole = inputCard.nextLine();
        	
        	System.out.println("Your rank is " + playersReal[j].getRank());
        	
        	if (cardRole.equalsIgnoreCase("y")) {
        		
        		boolean valid = false;
        		
        		while(!valid) {
        			
        			System.out.println("Pick one of these on card roles.");
        			System.out.println(Arrays.toString(sceneRole));
        			
        			Scanner roleChoose = new Scanner(System.in);
        			String roleChoice = roleChoose.nextLine();
        			
        			try {
        				int chooseRole = Integer.parseInt(roleChoice);
        				
        				boolean inRole = false;
        				
        				for(int q = 0; q < sceneRole.length; q++) {
        					if (chooseRole == sceneRole[q]) {
        						inRole = true;
        						break;
        					}
        				}
        				
        				if (chooseRole >= playersReal[j].getRank() && inRole) {
        					System.out.println("You now have this role.");
        					playersReal[j].takeRole(chooseRole, true);
        					valid = true;
        				}
        			} catch (Exception e) {
        				System.out.println("Not a valid role");
        			}
        		}
        		
        		
        		
        	} else {
        		
        		boolean valid = false;
        		
        		while(!valid) {
        			
        			System.out.println("Pick one of these off card roles.");
        			System.out.println(Arrays.toString(locRole));
        			
        			Scanner roleChoose = new Scanner(System.in);
        			String roleChoice = roleChoose.nextLine();
        			
        			try {
        				int chooseRole = Integer.parseInt(roleChoice);
        				
        				boolean inRole = false;
        				
        				for(int q = 0; q < locRole.length; q++) {
        					if (chooseRole == locRole[q]) {
        						inRole = true;
        						break;
        					}
        				}
        				
        				if (chooseRole >= playersReal[j].getRank() && inRole) {
        					System.out.println("You now have this role.");
        					playersReal[j].takeRole(chooseRole, false);
        					valid = true;
        				}
        			} catch (Exception e) {
        				System.out.println("Not a valid choice.");
        			}
        		}
        	}
        }
        
        location_value = playersReal[j].getLocation();
    	current_location = boardloc.locationName(location_value);
    
    	
    
    	if(current_location.equalsIgnoreCase("casting")) {
    		System.out.println("You are not able to work when at the " + current_location);
    	}else if(current_location.equalsIgnoreCase("trailer")) {
    		System.out.println("You are not able to work when at the " + current_location);
    	}else {
   
    		System.out.println("You choose to work!");
    		System.out.println("Would you like to act (a) or rehearse (r)?");
    		Scanner work_input = new Scanner(System.in);
    		String work_choice = work_input.nextLine();
   
    		if(work_choice.equalsIgnoreCase("a")) {
    	
    	
    			System.out.println("You choose to act!");
    			int die_num = roll();
    			System.out.println("You rolled a " + die_num);
       
       
    			if (die_num + playersReal[j].getPractice() >= playersReal[j].getRoleRank()) {
    				System.out.println("Sucessful acting.");
    				playerLoc.updateShot();
    	   
    				if (onCard) {
    					playersReal[j].increaseCredits(2);
    				} else {
    					playersReal[j].increaseCredits(1);
    					playersReal[j].increaseDollars(1);
    				}
    			} else {
    				System.out.println("Failed acting.");
    	   
    				if (!onCard) {
    					playersReal[j].increaseDollars(1);
    				}
    			}
       
    		} else if (work_choice.equalsIgnoreCase("r")) {
    			System.out.println("You choose to Rehearse!");
    			System.out.println("You gained a Practice Chip!");
    			playersReal[j].increasePractice();
    			System.out.println("This is " + color_array[j] + " practice chip count: " + playersReal[j].getPractice());
    
    		} else {
    			System.out.println("You didn't choose to act or rehearse, so we just will wait here");
    		}
    	}
       
       
       }else {
        System.out.println("Must choose m, w, or n");
       }
       
       }
        //Player has a role  
        }else {
        System.out.println("You are on role, You can Work(w) or do Nothing (n)");
       while(turn_check == false) {
       Scanner turn_input = new Scanner(System.in);
       String choice = turn_input.nextLine();
       if(choice.equalsIgnoreCase("n")) {
        turn_check = true;
        j++;
       }else if(choice.equalsIgnoreCase("w")) {
        turn_check = true;
      //takes role at set at current location.
        System.out.println("You choose to work on the set");
        
        int location_value = playersReal[j].getLocation();
    	current_location = boardloc.locationName(location_value);
    
    
        Location playerLoc = boardloc.getLocation(location_value);
    	Scene locScene = board.get(playerLoc);
    
    	int[] locRole = playerLoc.getRoles();
        int[] sceneRole = locScene.sceneRoles();
    
    	int shot = playerLoc.getShot();
    	boolean onCard = playersReal[j].getCard();
        
        

        
        location_value = playersReal[j].getLocation();
    	current_location = boardloc.locationName(location_value);
    
    	
    
    	if(current_location.equalsIgnoreCase("casting")) {
    		System.out.println("You are not able to work when at the " + current_location);
    	}else if(current_location.equalsIgnoreCase("trailer")) {
    		System.out.println("You are not able to work when at the " + current_location);
    	}else {
   
    		System.out.println("You choose to work!");
    		System.out.println("Would you like to act (a) or rehearse (r)?");
    		Scanner work_input = new Scanner(System.in);
    		String work_choice = work_input.nextLine();
   
    		if(work_choice.equalsIgnoreCase("a")) {
    	
    	
    			System.out.println("You choose to act!");
    			int die_num = roll();
    			System.out.println("You rolled a " + die_num);
       
       
    			if (die_num + playersReal[j].getPractice() >= playersReal[j].getRoleRank()) {
    				System.out.println("Sucessful acting.");
    				playerLoc.updateShot();
    				
    				//playersReal[j].resetRole();
    	   
    				if (onCard) {
    					playersReal[j].increaseCredits(2);
    				} else {
    					playersReal[j].increaseCredits(1);
    					playersReal[j].increaseDollars(1);
    				}
    			} else {
    				System.out.println("Failed acting.");
    	   
    				if (!onCard) {
    					playersReal[j].increaseDollars(1);
    				}
    			}
    			
    			boolean sceneFin = checkScene(playerLoc);
    			
    			if (sceneFin) {
    				System.out.println("Scene is wrapped.");
    				bonus(playersReal, locScene, playerLoc);
    				scene_count = scene_count - 1;
    			}
       
    		} else if (work_choice.equalsIgnoreCase("r")) {
    			System.out.println("You choose to Rehearse!");
    			System.out.println("You gained a Practice Chip!");
    			playersReal[j].increasePractice();
    			System.out.println("This is " + color_array[j] + " practice chip count: " + playersReal[j].getPractice());
    
    		} else {
    			System.out.println("You didn't choose to act or rehearse, so we just will wait here");
    		}
    	}
	
       
       }else {
        System.out.println("Must choose w or n");
       }        
       }
        }
       }
     

       j++;
       System.out.println(" ");
      }
    scene_count--;
    }
   next = true;
    }
   
 
 int[] score_arr = new int[playerCount];
 for(int x = 0; x < playerCount; x++) {
 int calc = 0;
 score_arr[x] = (playersReal[x].getcredits() + playersReal[x].getDollars() + (playersReal[x].getRank() * 5));
 }
 int max = 0;
 int max_pos = 0;
 for(int y = 0; y < playerCount; y++) {
 if(score_arr[y] > max) {
 max = score_arr[y];
 max_pos = y;
 }
 }
 System.out.println("Congrats to " + color_array[max_pos] + " for being the winner of the game with a score of " + max);
  }
  
  public static boolean checkScene(Location loc) {
	  
	  int shot = loc.getShot();
	  
	  if (shot == 0) {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public static void bonus(Player[] players, Scene scene, Location loc) {
	  
	  int budget = scene.getBudget();
	  
	  ArrayList<Player> playerOn = new ArrayList<Player>();
	  ArrayList<Player> playerOff = new ArrayList<Player>();
	  
	  for (int i = 0; i < players.length; i ++) {
		  if(players[i].getLocation() == loc.getIndex()) {
			  if(players[i].getCard()) {
				  playerOn.add(players[i]);
			  }else {
				  playerOff.add(players[i]);
			  }
		  }
	  }
	  
	  
	  if (!playerOn.isEmpty()) {
		  
		  if(!playerOff.isEmpty()) {
			  
			  for (Player p : playerOff) {
				  p.increaseDollars(p.getRoleRank());
			  }
		  }
		  
		  int[] rolls = new int[budget];
		  
		  for (int w = 0; w < budget; w++) {
			  rolls[w] = roll();
		  }
		  
	  }
  }

  public static int roll(){
    return (int)(Math.random()*6) + 1;
  }

}