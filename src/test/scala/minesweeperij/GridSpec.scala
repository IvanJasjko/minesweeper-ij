package minesweeperij

import org.scalatest._

class GridSpec extends FunSuite with Matchers {

  val testGrid = new Grid(8, 8).mineGrid

  test("Check grid size") {
    testGrid.length shouldBe 64
  }

  test("Check number of mines") {
    val mines = testGrid.filter(_._2 == true)
    mines.length shouldBe 10
  }
}

