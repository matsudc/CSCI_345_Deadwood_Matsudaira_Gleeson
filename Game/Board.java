<<<<<<< HEAD
import Player;
import Scene;
import Location;
=======
import Game.Scene;
import Game.Location;
import Game.Deadwood;
import Game.Player;
>>>>>>> 127684a4f09102ebc088625524025bfc4ae11a06

public class Board{

  //needs location array and scene array

  // KEY
  // ------------------------------------
  // trailer  = 0
  // hotel = 1
  // church = 2
  // bank = 3
  // ranch = 4
  // secret hideout = 5
  // casting office = 6
  // train station = 7
  // jail = 8
  // general store = 9
  // saloon = 10
  // main street = 11
  //------------------------------------

  //build board, sets locations info and pairs with scenes
  //need to return location/scene pairs
  public void buildBoard(){

    //location name = new location(index, name, int[moves], int[roles], shot)
    Location trailer = new Location(0, "Trailer", []);
    Location hotel = new Location(1, "Hotel", [], [1,1,2,3], 3);
    Location church = new Location(2, "Church", [], [1,2], 2);
    Location bank = new Location(3, "Bank", [], [2,3], 1);
    Location ranch = new Location(4, "Ranch", [], [1,2,3], 2);
    Location hideout = new Location(5);
    Location casting = new Location(6);
    Location train = new Location(7);
    Location jail = new Location(8);
    Location store = new Location(9);
    Location saloon = new Location(10);
    Location mainSt = new Location(11);

    //board[location, scene] --> board[location, new scene]

    //scanner reads new line from txt file

    // location[1,2,3,...]
    // scene[1,2,3,...]
    //
    // for each loacction: pick random scene num -> pair to location (except 0, 6)

    //boardPairs[12][2]= [[location[x], scene[y]]...]
  }

  //this will have 10 scenes, all with budget, #of roles, and then rank of each role available
public void resetBoard(){
  //sets all used scenes to false -> unable to use again
  //pairs new scenes with locations
}
}
