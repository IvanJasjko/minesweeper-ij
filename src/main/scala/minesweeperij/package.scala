package object minesweeperij {

  type Cords = (Int, Int)

  type CordsList = Seq[(Int, Int)]

  type MwGrid = Map[Cords, (Boolean, Int)]

}
