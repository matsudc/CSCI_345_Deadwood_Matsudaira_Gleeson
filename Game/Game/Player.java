package Game;


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
 public void increaseCredits(int amount, String name){
this.name = name;
this.credits = this.credits + amount;
}
 
 public void decreaseCredits(int amount, String name) {
this.name = name;
this.credits = this.credits - amount;
 }
 
 public int getcredits(String name) {
this.name = name;
return this.credits;
 }
 
 //Practice
 public void increasePractice(String name){
this.name = name;
this.practice = this.practice +1;
}
 
 public void resetPractice(String name){
this.name = name;
  this.practice = 0;
}
 
 public int getPractice(String name) {
this.name = name;
return this.practice;
 }
 
 //Dollars
 public void increaseDollars(int amount, String name){
this.name = name;
this.dollars = this.dollars + amount;
}
 public void decreaseDollars(int amount, String name){
this.name = name;
this.dollars = this.dollars - amount;
}
 public int getDollars(String name) {
this.name = name;
return this.dollars;
 }
 
//Rank
 public void increaseRank(int amount, String name){
  this.name = name;
  this.rank = this.rank + amount;
}
 public int getRank(String name) {
this.name = name;
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



}
