package minesweeperij

import scala.util.Random


class Grid(width: Int, length: Int) {

  def nM(): Int = {
    0
  }

  private val random = new Random

  // A standard 8*8 minesweeper board has 10 bombs
  private val mineCount = (width * length / 6.4).toInt

  private val emptyGrid = for(
    i <- 1 to width;
    j <- 1 to length
  ) yield (i, j)

  private val mineCords = random.shuffle(emptyGrid).take(mineCount)

  // Requires 2 traversals :(
  val mineGrid = emptyGrid.map( x => if (mineCords contains x) (x, (true, nM())) else (x, (false, nM())) ).toMap

  val size = mineGrid.size
  val gridWidth = width
  val gridLength = length

}
