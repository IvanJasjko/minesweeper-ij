package minesweeperij

import Utils.range2

class Drawer(gameGrid: Grid) {

  private def pPrint(symbol: String) {
    print(symbol)
    print(" ")
  }

  def printGrid(openCords: CordsList): Unit = {
    for (j <- 1 to gameGrid.gridLength) {
      println()

      for (i <- 1 to gameGrid.gridWidth) {

        if (openCords contains (i, j)) {
          // Checks if bomb condition is true
          if (gameGrid.mineGrid(i, j)._1)
            pPrint("B")
          else
            pPrint(gameGrid.mineGrid(i, j)._2.toString)
        } else {
          pPrint("#")
        }
      }
    }
    println("\n")
  }

  def printOutcome(text: String): Unit = {
    println(text)
    printGrid(range2(gameGrid.gridWidth, gameGrid.gridLength))
    System.exit(0)
  }
}
