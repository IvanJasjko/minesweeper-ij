package minesweeperij

import Utils._

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class GamePlay(gameGrid: Grid, output: Drawer) {

  //Assigning types to everything seems ugly
  @tailrec
  private def askCords(desc: String): (Int, Int) = {
    println(desc)

    val inputCords = scala.io.StdIn.readLine()
          .split("\\D+").toList

    if (inputCords.length != 2) {
      askCords(desc)
    }
    else {
      inputCords match { case List(a: String, b: String) => (a.toInt, b.toInt): (Int, Int) }
    }
  }

  private def cellExpand(initCells: List[(Int, Int)]): List[(Int, Int)] = {
    List((69,69),(70,70))
  }

  def playGame(): Unit = {
    val openCells = ListBuffer[(Int, Int)]()

    println("Game Started!")
    output.printGrid(openCells)

    while(!haveCommons(openCells, gameGrid.mineCords)) {
      val oc = askCords("Enter coordinates to open a cell:")

      if (!(openCells contains oc) && (oc._2 < gameGrid.gridWidth) && (oc._1 < gameGrid.gridLength))
        openCells += oc

      cellExpand(openCells.toList).foreach(openCells +=)

      output.printGrid(openCells)

      val safeCells = gameGrid.mineGrid.map{ case (cords, bombs) => if (!bombs._1) cords }.filter(_ != ())

      if (openCells.toSet == safeCells.toSet)
          output.printOutcome("You've Won! :)")
    }
    output.printOutcome("You've Lost :(")
  }
}
