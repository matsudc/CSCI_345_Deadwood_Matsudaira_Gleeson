package Game;


//import Game.Board;
//import Game.Scene;
//import Game.Location;
//import Game.Deadwood;




public class Player{

String name;
int credits;
int money;
int rank;
int practice;
int location;
boolean card;
int roleRank;

 public void Player(String name){
   this.name = name;
   this.rank = 1;
   this.credits = 0;
   this.money = 0;
   this.practice = 0;
   this.location = 0;
   this.card = false;
   this.roleRank = -1;
 }


 public void increaseCredits(){
  this.credits = this.credits +1;
}

 public int getcredits(String name) {
this.name = name;
return this.credits;
 }

 public void resetLocation(){
   this.location = 0;
   this.card = false;
 }

 public void resetPractice(){
   this.practice = 0;
 }


 public void increaseRank(){
  this.rank = this.rank +1;
 }

 public int getRank(String name) {
this.name = name;
return this.rank;
 }

 public int getLocation(String name) {
this.name = name;
return this.location;
 }

 public void updateLocation(String name, int new_location) {
this.name = name;
this.location = new_location;
 }

 public void increaseMoney(){
   this.money = this.money +1;
 }

 public void takeRole(){
   //get role rank and save in rankRole
   //update card: true or false

   System.out.println("Take Role");
 }

 public void upgradeRank(){

   if (this.rank < 6){
     this.rank = this.rank +1;
   } else {
     System.out.println("Max rank. Unable to upgrade.");
   }
 }

 public void move(){
   //look at location for possible moves
   //int newLocation = player choose possible locations
   //if ok move:
    //this.location = newLocation
   System.out.println("Move");
 }

 public void work(int choice){

   //rehearse
   if (choice == 1){
     this.practice = this.practice +1;
   } else if (choice == 0){
     //roll die

     //compare to budget

     //if successful:
      //remove shot counter
      //check to see if scene is wrapped

        //if wrapped:
        //see if a player is on card -> pay bonus
        //reset practice chips

    //if failed:
      //if player off card:
        //pay receives $1

    System.out.println("work");
  } else {
    System.out.println("Unable to practice. Too many practice chips");
  }
}

}
