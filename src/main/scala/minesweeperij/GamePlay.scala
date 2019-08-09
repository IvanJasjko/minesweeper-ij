package minesweeperij

import Utils._

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class GamePlay(gameGrid: Grid, output: Drawer) {

  //Assigning types to everything seems ugly
  @tailrec
  private def askCords(desc: String): Cords = {
    println(desc)

    val inputCords = scala.io.StdIn.readLine()
          .split("\\D+").toList

    if (inputCords.length != 2) {
      askCords(desc)
    }
    else {
      inputCords match { case List(a: String, b: String) => (a.toInt, b.toInt): Cords }
    }
  }

  @tailrec
  private def cellExpand(initCell: Cords, oldCords: CordsList = List(), backTrack: CordsList = List()):
  (CordsList, CordsList) = {

    val game = gameGrid.mineGrid
    val finalCords = List(initCell) ++ oldCords

    if (game(initCell)._2 != 0)
      (finalCords, backTrack)

    else {
      val roundCords = rangeAround(initCell).filter(x => !(oldCords contains x) && (game contains x))
      val nearZeros = roundCords.filter(x => game(x)._2 == 0 && x != initCell)

      if (nearZeros.nonEmpty) {
        cellExpand(nearZeros.head, roundCords.filter(x => game(x)._2 != 0) ++ finalCords, nearZeros.tail ++ backTrack)
      }
      else if (backTrack.nonEmpty){
        cellExpand(backTrack.head, roundCords.filter(x => game(x)._2 != 0) ++ finalCords, backTrack.tail)
      }
      else
        (roundCords ++ finalCords, backTrack)
    }
  }

  def playGame(): Unit = {
    val openCells = ListBuffer[Cords]()

    println("Game Started!")
    output.printGrid(openCells)

    while(!haveCommons(openCells, gameGrid.mineCords)) {
      val oc = askCords("Enter coordinates to open a cell:")

      if (!(openCells contains oc) && (oc._1 <= gameGrid.gridWidth) && (oc._2 <= gameGrid.gridLength))
        cellExpand(oc)._1.foreach(openCells +=)

      output.printGrid(openCells)

      val safeCells = gameGrid.mineGrid.map{ case (cords, bombs) => if (!bombs._1) cords }.filter(_ != ())

      if (safeCells.toSet.subsetOf(openCells.toSet))
          output.printOutcome("You've Won! :)")
    }
    output.printOutcome("You've Lost :(")
  }
}
