package minesweeperij

import scala.util.Random
import Utils._

class Grid(width: Int, length: Int) {
  private val random = new Random

  private def surMines(cords: (Int, Int), mineCords: IndexedSeq[(Int, Int)]): Int = {
    val surCords = rangeAround(cords._1, cords._2)
    val mines = for (i <- surCords if mineCords.contains(i)) yield i
    mines.length
  }

  // A standard 8*8 minesweeper board has 10 bombs
  private val mineCount = (width * length / 6.4).toInt

  private val emptyGrid = range2(width, length)
  private val mineCords = random.shuffle(emptyGrid).take(mineCount)

  // Requires 2 traversals :(
  val mineGrid: MwGrid = emptyGrid
    .map( x => if (mineCords contains x) (x, (true, surMines(x, mineCords))) else (x, (false, surMines(x, mineCords))) )
    .toMap

  val size: Int = mineGrid.size
  val gridWidth: Int = width
  val gridLength: Int = length

}
