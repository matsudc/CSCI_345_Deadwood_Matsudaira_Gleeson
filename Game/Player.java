public class Player{

String name;
int credits;
int money;
int rank;
int practice;

 public void Player(String name){
   this.name = name;
   this.rank = 1;
   this.credit = 0;
   this.money = 0;
   this.practice = 0;
 }

 public void resetPractice(){
   this.practice = 0;
 }

 public void increaseCredits(){
   this.credits = this.credits +1;
 }

 public increaseMoney(){
   this.money = this.money +1;
 }

 public void upgradeRank(){

   if (this.rank < 6){
     this.rank = this.rank +1;
   } else {
     System.println("Max rank. Unable to upgrade.");
   }
 }

 public void move(){
   //move player
   //find location of player
   //tell player possible locations to move to
   //player chooses location
   //move player to location on board
 }

 public void work(int choice){

   //rehearse
   if (choice == 1){
     this.practice = this.practice +1;
   } else if (choice == 0){
     //roll die

     //compare to budget

     //if sucessful:
      //remove shot counter
      //check to see if scene is wrapped

        //if wrapped:
        //see if a player is on card -> pay bonues
        //reset practice chips

    //if failed:
      //if player off card:
        //pay receives $1

    System.println("work");
  } else {
    System.out.println("Unable to practice. Too many practice chips")
  }
}

}
