package minesweeperij

object Main {

  def main(args: Array[String]): Unit = {
    val gameGrid = new Grid(4, 4)
    val output = new Drawer(gameGrid)
    new GamePlay(gameGrid, output).playGame()
  }
}
