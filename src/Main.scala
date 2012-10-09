package ch.unige.epsilord.demo

import ch.unige.epsilord._

object Main extends App {

  val o = doubleOrdering(0.01)
  import o._

  println( 2.0 *<=* 2.005 )

}
