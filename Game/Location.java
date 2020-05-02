<<<<<<< HEAD
import Board;
=======
import Game.Player;
import Game.Board;
import Game.Scene;
import Game.Deadwood;

>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06

public class Location{

int index;
int shot;
int[] role;
int[] moves;
String name;

  public static void Location(int index, String name, int[] moves){
    this.index = index;
    this.name = name;
    this.moves = moves
  }

  public static void Location(int index, String name, int[] moves, int[] roles, int shot){
    this.index = index;
    this.name = name;
    this.moves = moves
    this.shot = shot;
    this.roles = roles;
  }

  public int[] getRoles(){
    return this.roles;
  }

  public void updateRoles(int index){
    this.roles[index] = -1,
  }

  public void updateShot(){
    this.shot = this.shot - 1;
  }

  public int getShot(){
    return this.shot;
  }

  public String getName(){
    return this.name;
  }

  public int[] getMoves(){
    return this.moves;
  }
}
