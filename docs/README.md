# LPOO_19 - Breakout

In this project we are creating a game that looks a lot like "Breakout". The objective is to not let the ball fall below the screen before destroying all the blocks above (by hitting them with it).

This is the current state of the project:

<img src="game.gif" height="500">

This project was developed by Rafael Cristino (@rafaavc, up201806680@fe.up.pt) and Xavier Pisco (@Xavier-Pisco, up201806314@fe.up.pt) for LPOO 2019/20.


## Implemented features

### Drawing and moving the player's bar 

The player's bar is being drawn close to the bottom of the screen and in the middle of width of the screen.<br/>
It can be moved left or right by pressing the left or right arrows on the keyboard.

### Drawing and moving ball with collisions and bounces

The game's ball is being drawn and starts close in the middle of the width of the screen and a bit above the players bar.

The ball will move with time. In the begin it will move right up. The ball changes it's direction according to the collisions it suffers.

If the ball hits either the top of the screen, the sides of the screen, the player bar or the tiles it will bounce from that surface in the correct angle. However, if the ball hits the bottom of the screen, the game is over.

### Drawing and checking collisions with tiles

The tile grid is being generated and drawn and the collisions of the ball with the tiles are being checked. The color of the tiles depends on the amount of health they have. When a tile reaches 0 health it is removed.


## Planned Features

- [x] Draw the arena
- [x] Add the players bar
- [x] Move the bar
- [x] Draw the ball
- [x] Move the ball 
- [x] Add ball colisions and bounces
- [x] Draw the tiles
- [x] Add colisions with tiles
- [ ] Add scoreboard
- [ ] Add menus

(these are just more ideas)
- [ ] Add shots coming from above to hurt the player
- [ ] Add special powers (for example: make the ball bigger for a few seconds, make the player bar bigger, increase/decrease the ball velocity)
- [ ] Add player lives


## Design

// This needs to be refactored to be like the template

So far, we've used the following design patterns in the development of our project:

- Adapter pattern (for the graphics interface with which the view interacts)

<img src="AdapterPatternGraphics.png" height="300">

- Command pattern (for the Commands comming from the keyboard input and for the BallHits)

- MVC (for the arena and it's various elements; implementation is not yet finished)

- Factory && Abstract Factory pattern (at the moment for converting enum types to Commands and BallHits and also to create Views)


## Known code smells and refactoring sugestions

// TODO


## Testing


// TODO

## Self-evaluation


// TODO
