package minesweeperij


object Main {

  def main(args: Array[String]): Unit = {

    val gameGrid = new Grid(8, 8)
    val mwGame = new Game(gameGrid)
    mwGame.printGrid()

  }
}
