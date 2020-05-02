<<<<<<< HEAD
import Player;
import Board;

=======
>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06
import java.util.Random;
import Game.Player;
import Game.Board;
import Game.Scene;
import Game.Location;


public class Deadwood{

  public int die;

  public static void main(String[] args){
    int playerCount;
    String[] playerName;
<<<<<<< HEAD
    //String[playerCount][4] playerScores;
=======
    String[][] playerScores;
>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06
    //playerCount lets us see how many players to playerCount
    //4 represents the 4 stats of each player; rank, credits, dollars, practice chips;
    //for loop to fill playerScores with proper info;

    //build board
    //Board game = new Board();

    //setDays depends on playercount info
    int setDays;
    int dayCounter = 1;

    //while setDays + 1 != dayCounter{
      //while(scenes left on board){
      //call players 1 by 1;
        //}

    //setDays += 1;
    //reset board -> pair new locations w/ new scenes
   //}
<<<<<<< HEAD

    //getScoreWinnner(playerScores);
    System.out.println("test");
=======
   // getScoreWinnner(playerScores);
>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06
  }

  public void roll(){
    die = (int)(Math.random()*6) + 1);
  }

  //calculates each players total score and then compares for winner
  public static void getScoreWinnner(){
    //loop that takes first 3 values of each player and compares with others to see who is getScoreWinnner
    //return winner;
  }

}
