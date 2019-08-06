package minesweeperij

object Main {

  def main(args: Array[String]): Unit = {
    val gameGrid = new Grid(8, 8)
    val output = new Drawer(gameGrid)
    new GamePlay(gameGrid, output).playGame()
  }
}
