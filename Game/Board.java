package Game;


//import Game.Scene;
//import Game.Location;
//import Game.Deadwood;
//import Game.Player;

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

  //build board, sets locations info and pairs with scenes -> hashmap?
  //need to return location/scene pairs
  public void buildBoard(){
int[] moving = new int[]{1, 10 , 11};
int[] rolling = new int[] {1, 1, 2, 3};
    //Location name = new location(index, name, int[moves], int[roles], shot)
   // Location trailer = new Location();
   // trailer.Location(0, "Trailer", [1, 10, 11]);
 // trailer.Location(0, "Trailer" , moving);
   // Location hotel = new Location();
    // hotel.Location(1, "Hotel", [0, 2, 3], [1, 1, 2, 3] , 3);

  //  Location church = new Location();
  // church.Location(2, "Church", [1, 3, 5], [1,2], 2);

//  Location bank = new Location();
  // bank.Location(3, "Bank", [1, 2, 4, 10], [2,3], 1);

  //Location ranch = new Location();
  // ranch.Location(4, "Ranch", [3, 5, 6, 9], [1, 2,3], 2);

 // Location hideout = new Location();
  // hideout.Location(5, "Hideout", [2, 4, 6], [1, 2, 3, 4], 3);

  //Location casting = new Location();
  // casting.Location(6, "Casting", [4, 5, 7]);

  //Location train = new Location();
  // train.Location(7, "Train", [6, 8, 9], [1, 1, 2, 4], 3);

  //Location jail = new Location();
  // jail.Location(8, "Jail", [7, 9, 11], [2, 3], 1);

  //Location store = new Location();
  // store.Location(9, "Store", [4, 7, 8, 10], [1, 3], 2);

  //Location saloon = new Location();
  // saloon.Location(10, "Saloon", [0, 3, 9, 11], [1,2], 2);

  //Location mainSt = new Location();
  // mainSt.Location(11, "MainSt", [0, 8, 10], [1, 2, 2, 4], 3);

    //scene name = new scene(index, name, budget, int[roles])
/*
    Scene scene0 = new Scene(7, "Evil Wears a Hat", 4, [2,3,4]);
    Scene scene1 = new Scene(14, "Square Deal City", 6, [2,4,6]);
    Scene scene2 = new Scene(20, "Law and the Old West", 3, [1,2,5]);
    Scene scene3 = new Scene(31, "Davy Crocket: A Drunkard's Tale", 4, [4,6]);
    Scene scene4 = new Scene(22, "Life and Times of John Skywater", 5, [5,6]);
    Scene scene5 = new Scene(34, "The Way the West was Run", 4, [2,4,5]);
    Scene scene6 = new Scene(32, "My Years on the Prairie", 5, [3,4,6]);
    Scene scene7 = new Scene(24, "Down in the Valley", 3, [1,3,5]);
    Scene scene8 = new Scene(12, "Buffalo Bill: The Lost Years", 4, [2,3,5]);
    Scene scene9 = new Scene(14, "Ol' Shooter and Little Doll", 4, [1,2,4]);
    Scene scene10 = new Scene(19, "The Robbers of Trains", 4, [1,4,5]);
    Scene scene11 = new Scene(8, "Jesse James: Man of Action", 5, [2,4,5]);
    Scene scene12 = new Scene(12, "Beyond the Pail: Life without Lactose", 2 , [6]);
    Scene scene13 = new Scene(6, "Disaster at Flying J", 5, [2,3,4]);
    Scene scene14 = new Scene(16, "A Man Called “Cow”", 3, [3,6]);
    Scene scene15 = new Scene(23, "Shakespeare in Lubbock", 3, [1,3,4]);
    Scene scene16 = new Scene(2, "Taffy Commercial", 2, [3,4]);
    Scene scene17 = new Scene(30, "Go West, You!", 3, [4,6]);
    Scene scene18 = new Scene(3, "Gum Commercial", 2, [2,4]);
    Scene scene19 = new Scene(15, "The Life and Times of John Skywater", 5, [3,5,6]);
    Scene scene20 = new Scene(25, "Gun! The Musical", 6, [4,5,6]);
    Scene scene21 = new Scene(21, "One False Step for Mankind", 6, [1,2,5]);
    Scene scene22 = new Scene(16, "Humor at the Expense of Others", 5, [2,4,5]);
    Scene scene23 = new Scene(15, "Thirteen the Hard Way", 5, [1,3,5]);
    Scene scene24 = new Scene(12, "The Search for Maggie White", 6, [5,6]);
    Scene scene25 = new Scene(2, "How They Get Milk", 4, [2,3,4]);
    Scene scene26 = new Scene(1, "Picante Sauce Commercial", 2, [3,5]);
    Scene scene27 = new Scene(27, "My Years on the Prairie", 5, [2,3,5]);
    Scene scene28 = new Scene(14, "Jesse James: Man of Action", 5, [1,4,6]);
    Scene scene29 = new Scene(12, "Davy Crockett: A Drunkard’s Tale", 4, [2,3,4]);
    Scene scene30 = new Scene(25, "Czechs in the Sonora", 4, [5,6]);
    Scene scene31 = new Scene(13, "J. Robert Lucky, Man of Substance", 4, [1,2,5]);
    Scene scene32 = new Scene(19, "Swing 'em Wide", 6, [1,3,5]);
    Scene scene33 = new Scene(17, "Thirteen the Hard Way", 5, [2,4,5]);
    Scene scene34 = new Scene(35, "Swing 'em Wide", 6, [3,5,6]);
    Scene scene35 = new Scene(8, "How They Get Milk", 4, [4,5,6]);
    Scene scene36 = new Scene(5, "Trials of the First Pioneers", 4, [2,4,5]);
    Scene scene37 = new Scene(19, "Breakin’ in Trick Ponies", 3, [2,6]);
    Scene scene38 = new Scene(9, "How the Grinch Stole Texas", 5, [3,4,5]);
    Scene scene39 = new Scene(40, "Custer’s Other Stands", 5, [2,4,6]);

  //  Scene[] scenes = new Scene[scene0,scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,scene12,scene13,scene14,scene15,scene16,scene17,scene18,scene19,scene20,scene21,scene22,scene23,scene24,scene25,scene26,scene27,scene29,scene30,scene31,scene32,scene33,scene34,scene35,scene36,scene37,scene38,scene39];
  //  Location[] locations = new Location[trailer, hotel, church, bank, ranch, hideout, casting, train, jail, store, saloon, mainSt];

    for (int i = 0; i < scenes.length; i++){
      System.out.println(scenes[i].getName());
    }

    for (int j = 0; j < locations.length; j++){
      System.out.println(locations[j].getName());
    }
    */
  }

  //this will have 10 scenes, all with budget, #of roles, and then rank of each role available
public void resetBoard(){
  //sets all used scenes to false -> unable to use again
  //pairs new scenes with locations
}
}
