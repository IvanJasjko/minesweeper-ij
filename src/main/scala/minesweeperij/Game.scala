package minesweeperij

class Game(gameGrid: Grid) {

  private def pPrint(symbol: Char = '\n') {
    print(symbol)
    print(" ")
  }

  def printGrid() = {
    for (i <- 1 to gameGrid.gridWidth) {
        pPrint()

      for (j <- 1 to gameGrid.gridLength) {
        if (gameGrid.mineGrid(i, j) == true)
          pPrint('B')
        else
          pPrint('#')
        }
      }
    pPrint()
  }
}
