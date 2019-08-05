package minesweeperij

class Drawer(gameGrid: Grid) {

  private def pPrint(symbol: String) {
    print(symbol)
    print(" ")
  }

  def printGrid(openCords: Seq[(Int, Int)], markedCords: Seq[(Int, Int)]): Unit = {
    for (i <- 1 to gameGrid.gridWidth) {
      println()

      for (j <- 1 to gameGrid.gridLength) {

        if (openCords contains (i, j))
          if (gameGrid.mineGrid(i, j)._1)
            pPrint("B")
          else
            pPrint(gameGrid.mineGrid(i, j)._2.toString)

        else if (markedCords contains (i, j))
          pPrint("F")

        else
          pPrint("#")
      }
    }
    println()
  }
}
