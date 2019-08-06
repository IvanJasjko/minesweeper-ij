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

  def playGame(): Unit = {
    val openCells = ListBuffer[(Int, Int)]()

    println("Game Started!")
    output.printGrid(openCells)

    while(!haveCommons(openCells, gameGrid.mineCords)) {
      val oc = askCords("Enter coordinates to open a cell:")

      if (!(openCells contains oc))
        openCells += oc

      output.printGrid(openCells)
    }

    output.printOutcome("You've Lost :(")
  }
}
