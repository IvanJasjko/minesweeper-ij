package minesweeperij
import Utils._

object Main {

  def main(args: Array[String]): Unit = {

    val gameGrid = new Grid(8, 8)
    val output = new Drawer(gameGrid)
    val game = new GamePlay(gameGrid, output)

  }
}
