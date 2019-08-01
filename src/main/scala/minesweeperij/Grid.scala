package minesweeperij

import scala.util.Random

class Grid(width: Int, length: Int) {

  private val random = new Random

  // A standard 8*8 minesweeper board has 10 bombs
  private val mineCount = (width * length / 6.4).toInt

  private val emptyGrid = for(
    i <- 1 to width;
    j <- 1 to length
  ) yield (i, j)

  private val mineCords = random.shuffle(emptyGrid).take(mineCount)

  val mineGrid = emptyGrid.map( x => if (mineCords contains x) (x, true) else (x, false) ).toVector

}
