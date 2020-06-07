package Game;


//import Game.Player;
//import Game.Board;
//import Game.Scene;
//import Game.Deadwood;


public class Location{

int index;
int shot;
int[] role;
int[] moves;
String name;
int[] area; //[x, y, h ,w]
int[][] offCardArea;

 public Location(int index, String name, int[] moves, int[] area){
    this.index = index;
    this.name = name;
    this.moves = moves;
    this.area = area;
  }


  public Location(int index, String name, int[] moves, int[] roles, int shot, int[] area, int[][] offCardArea){
    this.index = index;
    this.name = name;
    this.moves = moves;
    this.shot = shot;
    this.role = roles;
    this.area = area;
    this.offCardArea = offCardArea;
  }
  
  public int[] getArea() {
	  return this.area;
  }
  
  public int[][] getOffCardArea(){
	  return this.offCardArea;
  }

  public int[] getRoles(){
    return this.role;
  }

  public void updateRoles(int index){
    this.role[index] = -1;
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
  
  public int getIndex() {
	  return this.index;
  }
}
