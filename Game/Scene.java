<<<<<<< HEAD
import Board;
=======
import Game.Player;
import Game.Board;
import Game.Location;
import Game.Deadwood;
>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06

public class Scene{

  int sceneNum;
  int budget;
  int[] roles;
  String name;
  boolean use;

  public void Scene(int num, String name, int budget, int[] roles){
    this.name = name;
    this.budget = budget;
    this.roles = roles;
    this.use = true;
    this.sceneNum = num;
  }

  public void updateUse(){
    this.use = false;
  }

  public boolean getUse(){
    return this.use;
  }

  public void updateRoles(int index){
    this.roles[index] = -1;
  }

  public int[] getRoles(){
    return this.roles;
  }

  public int getBudget(){
    return this.budget;
  }

  public String getName(){
    return this.name;
  }
}
