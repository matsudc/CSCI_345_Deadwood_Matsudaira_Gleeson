import Board;

public class Scene{

  int sceneNum;
  int budget;
  int[] roles;
  String name;
  boolean use;

  public void Scene(String name, int budget, int[] roles, int num){
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

}
