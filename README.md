# Project
This is our translation of the board game known as Deadwood into Java.

#Files

Deadwood: This is the main file in which the game is run. This class controls the game. It creates players,
sets the number of days, and calculates the winner.

Player: This class is used to create players. It also has all the options a player can do during their turn such as
move, work, and upgrade. It also keeps track of each player's practice chips, money, credits, and rank.

Board: This class keep track of which scenes are where and also the location of each player. It also flips the
face down cards when needed.

Scene: This is a subclass of Board and has all the information needed for each scene such as number of on card roles, number of
off card roles, shot counters, scene's budget, and it also checks to see if a scene is complete.

Location: Has the information for each location on the board such as possible moves from this spot, shot counters, off card roles, etc.
