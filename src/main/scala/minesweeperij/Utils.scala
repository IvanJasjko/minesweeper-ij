package minesweeperij

object Utils {

  def range2(width: Int, length: Int): IndexedSeq[Cords] = {
    for(
      i <- 1 to width;
      j <- 1 to length
    ) yield (i, j)
  }

  def rangeAround(cords: Cords): IndexedSeq[Cords] = {
    for(
      i <- cords._1 - 1 to cords._1 + 1;
      j <- cords._2 - 1 to cords._2 + 1
    ) yield (i, j)
  }

  def haveCommons(l1: Seq[Cords], l2: Seq[Cords]): Boolean = {
    val dupes = for(i <- l1 if l2 contains i) yield i
    dupes.nonEmpty
  }
}
