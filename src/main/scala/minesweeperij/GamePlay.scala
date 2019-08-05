package minesweeperij

import Utils._

class GamePlay(gameGrid: Grid, output: Drawer) {

  output.printGrid(range2(gameGrid.gridWidth, gameGrid.gridLength), List())

}
