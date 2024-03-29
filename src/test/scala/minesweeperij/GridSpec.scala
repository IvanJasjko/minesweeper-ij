package minesweeperij

import org.scalatest._

class GridSpec extends FunSuite with Matchers {

  val testGrid: MwGrid = new Grid(8, 8).mineGrid

  test("Check grid size") {
    testGrid.size shouldBe 64
  }

  test("Check number of mines") {
    val mines = testGrid.filter(_._2._1 == true)
    mines.size shouldBe 10
  }
}

