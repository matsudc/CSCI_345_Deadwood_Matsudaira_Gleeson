package Game;

import java.util.Scanner;

//import Game.Board;
//import Game.Scene;
//import Game.Location;
//import Game.Deadwood;




public class Player{

String name;
int credits;
int dollars;
int rank;
int practice;
int location;
boolean card;
int roleRank;

 public void Player(String name){
   this.name = name;
   this.rank = 1;
   this.credits = 0;
   this.dollars = 0;
   this.practice = 0;
   this.location = 0;
   this.card = false;
   this.roleRank = -1;
 }
 
 
 //credits
 public void increaseCredits(int amount){
this.credits = this.credits + amount;
}
 
 public void decreaseCredits(int amount) {
this.credits = this.credits - amount;
 }
 
 public int getcredits() {
return this.credits;
 }
 
 //Practice
 public void increasePractice(){
this.practice = this.practice +1;
}
 
 public void resetPractice(){
this.practice = 0;
}
 
 public int getPractice() {
return this.practice;
 }
 
 //Dollars
 public void increaseDollars(int amount){
this.dollars = this.dollars + amount;
}
 public void decreaseDollars(int amount){
this.dollars = this.dollars - amount;
}
 public int getDollars() {
return this.dollars;
 }
 
//Rank
 public void updateRank(int amount){
  this.rank = amount;
}
 public int getRank() {
return this.rank;
 }
 
 //Location
 public void resetLocation(){
   this.location = 0;
   this.card = false;
 }
 public int getLocation(String name) {
this.name = name;
return this.location;
 }
 public void updateLocation(String name, int new_location) {
this.name = name;
this.location = new_location;
 }



 public void takeRole(){
   //get role rank and save in rankRole
   //update card: true or false

   System.out.println("Take Role");
 }

public void upgrade() {
System.out.println("Welcome to the casting office!");
System.out.println("You can upgrade your rank using Dollars or Credits!");
System.out.println("Rank 2 requires either 4 dollars or 5 credits");
System.out.println("Rank 3 requires either 10 dollars or 10 credits");
System.out.println("Rank 4 requires either 18 dollars or 15 credits");
System.out.println("Rank 5 requires either 28 dollars or 20 credits");
System.out.println("Rank 6 requires either 40 dollars or 25 credits");
System.out.println(this.name + ", you currently are rank " + this.getRank() + " with "
+ this.getcredits() + " credits and " + this.getDollars() + " dollars");
System.out.println("So would you like to upgrade your rank?");
System.out.println("Yes (y) or No (n)?");
Scanner upgrade_input = new Scanner(System.in);
String upgrade_choice = upgrade_input.nextLine();
if(upgrade_choice.equalsIgnoreCase("y")) {

System.out.println("Will you use Credits (c) or Dollars (d)?");
Scanner upgrade_wealth_input = new Scanner(System.in);
    String upgrade_wealth_choice = upgrade_wealth_input.nextLine();
    if(upgrade_wealth_choice.equalsIgnoreCase("c")) {
    //credit check for what upgrade they can do:
    if(this.getcredits() < 5) {
    System.out.println("You dont have enough credits to upgrade, sorry");
    }else if (this.getcredits() < 10) {
    System.out.println("You can upgrade to rank 2 only");
    if(this.getRank() >= 2) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                this.decreaseCredits(5);
                this.updateRank(2);
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    }else if (this.getcredits() < 15) {
    System.out.println("You can upgrade to rank 2 or rank 3");
    if(this.getRank() >= 3) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2 or rank 3? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 3 (3) or rank 2 (2)?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseCredits(5);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseCredits(10);
                    this.updateRank(3);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    }else if (this.getcredits() < 20) {
    //upgrade any but 5 and 6
    System.out.println("You can upgrade to rank 2, 3 or 4");
    if(this.getRank() >= 4) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3 or 4? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), or rank 4 (4)?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseCredits(5);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseCredits(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseCredits(15);
                    this.updateRank(4);
                    } else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }  
    }else if (this.getcredits() < 25) {
    //upgrade any but 6
    System.out.println("You can upgrade to rank 2, 3, 4 or 5");
    if(this.getRank() >= 5) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3, 4 or 5? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), rank 4 (4), or rank 5?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseCredits(5);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseCredits(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseCredits(15);
                    this.updateRank(4);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("5")) {
                    this.decreaseCredits(20);
                    this.updateRank(5);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    }else {
    //you can upgrade any
    System.out.println("You can upgrade to any rank");
    if(this.getRank() >= 6) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3, 4, 5, 6? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), rank 4 (4), rank 5, or rank 6?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseCredits(5);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseCredits(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseCredits(15);
                    this.updateRank(4);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("5")) {
                    this.decreaseCredits(20);
                    this.updateRank(5);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("6")) {
                    this.decreaseCredits(25);
                    this.updateRank(6);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
   
    }                
    }else if (upgrade_wealth_choice.equalsIgnoreCase("d")) {
    //choose to use dollars. check to see if they can upgrade.
    //cant upgrade to any rank
    if(this.getDollars() < 4) {
    System.out.println("You dont have enough dollars to upgrade, sorry");
    //upgrade only rank 2
    }else if (this.getcredits() < 10) {
    System.out.println("You can upgrade to rank 2 only");
    if(this.getRank() >= 2) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                this.decreaseDollars(4);
                this.updateRank(2);
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    //upgrade to rank 2,3
    }else if (this.getDollars() < 18) {
    System.out.println("You can upgrade to rank 2 or rank 3");
    if(this.getRank() >= 3) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2 or rank 3? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 3 (3) or rank 2 (2)?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseDollars(4);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseDollars(10);
                    this.updateRank(3);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    //upgrade to rank 2,3,4
    }else if (this.getcredits() < 28) {
    System.out.println("You can upgrade to rank 2, 3 or 4");
    if(this.getRank() >= 4) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3 or 4? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), or rank 4 (4)?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseDollars(4);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseDollars(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseDollars(18);
                    this.updateRank(4);
                    } else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }  
    //upgrade to rank 2,3,4,5
    }else if (this.getDollars() < 40) {
    System.out.println("You can upgrade to rank 2, 3, 4 or 5");
    if(this.getRank() >= 5) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3, 4 or 5? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), rank 4 (4), or rank 5?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseDollars(4);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseDollars(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseDollars(18);
                    this.updateRank(4);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("5")) {
                    this.decreaseDollars(28);
                    this.updateRank(5);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }
    //you can upgrade any
    }else {
    System.out.println("You can upgrade to any rank");
    if(this.getRank() >= 6) {
    System.out.println("However, you are already at rank " + this.getRank() + " and cant down grade rank");
    }else {
    System.out.println("Continue upgrading to rank 2, 3, 4, 5, 6? Yes (y) or no (n) ");
            Scanner upgrade_decision_input = new Scanner(System.in);
                String upgrade_decision = upgrade_decision_input.nextLine();
                if(upgrade_decision.equalsIgnoreCase("y")) {
                System.out.println("Rank 2 (2), rank 3 (3), rank 4 (4), rank 5, or rank 6?");
                Scanner upgrade_decision_input_rank = new Scanner(System.in);
                    String upgrade_decision_rank = upgrade_decision_input_rank.nextLine();
                    if(upgrade_decision_rank.equalsIgnoreCase("2")) {
                    this.decreaseDollars(4);
                    this.updateRank(2);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("3")) {
                    this.decreaseDollars(10);
                    this.updateRank(3);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("4")) {
                    this.decreaseDollars(18);
                    this.updateRank(4);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("5")) {
                    this.decreaseDollars(28);
                    this.updateRank(5);
                    }else if (upgrade_decision_rank.equalsIgnoreCase("6")) {
                    this.decreaseDollars(40);
                    this.updateRank(6);
                    }else {
                    System.out.println("Not a value to choose"); // need to make loop instead or something
                    }
                }else {
                System.out.println("Okay, well no upgrade for you");
                }
    }                
    }                              
    }else {
    System.out.println("Failed to choose either option...");
    }      
}else {
System.out.println("Oh well, hopefully you can upgrade next time!");
}
}

}
