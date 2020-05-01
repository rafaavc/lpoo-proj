# LPOO_19 - Breakout

In this project we are creating a game that looks a lot like "Breakout". The objective is to not let the ball fall below the screen before destroying all the blocks above (by hitting them with it).

This is the current state of the project:

<img src="game.gif" height="500"/>

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

### We want to work in the different components without affecting one another and improve modularity

#### The problem in context

#### The pattern
- MVC (for the arena and it's various elements)

#### Implementation

#### Consequences

### We shouldn't need to interact directly with Lanterna to draw objects in the View

#### The problem in context
The view shouldn't be interacting with the graphics directly. We don't want to have to worry about the specifics of the graphics library being used at the moment while writing the view of each component, therefore we needed to reccur to abstraction. This is also helpful if we want to have the possibility of changing the graphics library easily, while not having to worry about it in the view.

#### The pattern
We applied the **Adapter pattern**. (speak about adapter pattern)

#### Implementation
<img src="AdapterPatternGraphics.png" height="300"/>

The classes can be found in these files:
- View:
  -  [ArenaView](../src/main/java/com/g19/breakout/view/ArenaView.java)
  -  [ElementView](../src/main/java/com/g19/breakout/view/ElementView.java)
  -  [BallView](../src/main/java/com/g19/breakout/view/BallView.java)
  -  [PlayerBarView](../src/main/java/com/g19/breakout/view/PlayerBarView.java)
  -  [TilesView](../src/main/java/com/g19/breakout/view/TilesView.java)
- [Graphics](../src/main/java/com/g19/breakout/view/graphics/Graphics.java)
- [LanternaAdapter](../src/main/java/com/g19/breakout/view/graphics/LanternaAdapter.java)

#### Consequences
The use of the Adapter pattern in the current design allows for the following benefits:
- 1
- ...

### We want to be able to inject the classes that the ArenaView needs to create

#### The problem in context

#### The pattern
- Abstract Factory pattern (to create Views)

#### Implementation

#### Consequences

### We want to convert enum types to Commands and BallHits in a simple and clean way

#### The problem in context

#### The pattern
- Factory pattern - at the moment for converting enum types to Commands and BallHits 

#### Implementation

#### Consequences

### We want our ArenaController to not have to worry about which command was given nor which object the ball hit

#### The problem in context

#### The pattern
- Command pattern (for the Commands comming from the keyboard input and for the BallHits)

#### Implementation

#### Consequences


## Known code smells and refactoring sugestions

// TODO


## Testing

- Screenshot of coverage report.
- Link to mutation testing report.


## Self-evaluation

- Rafael Cristino - 50%
- Xavier Pisco - 50%
