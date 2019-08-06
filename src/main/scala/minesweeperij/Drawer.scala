package minesweeperij

class Drawer(gameGrid: Grid) {

  private def pPrint(symbol: String) {
    print(symbol)
    print(" ")
  }

  def printGrid(openCords: CordsList): Unit = {
    for (i <- 1 to gameGrid.gridWidth) {
      println()

      for (j <- 1 to gameGrid.gridLength) {

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
    val allCords = Utils.range2(gameGrid.gridWidth, gameGrid.gridLength)
    printGrid(allCords)
    System.exit(0)
  }
}
