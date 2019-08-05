package minesweeperij

object Utils {

  def range2(width: Int, length: Int): IndexedSeq[(Int, Int)] = {
    for(
      i <- 1 to width;
      j <- 1 to length
    ) yield (i, j)
  }

  def rangeAround(width: Int, length: Int): IndexedSeq[(Int, Int)] = {
    for(
      i <- width - 1 to width + 1;
      j <- length - 1 to length + 1
    ) yield (i, j)
  }

}
