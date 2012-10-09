EPSILon ORDdering (epsilord)
============================

`scala.math.Ordering` for Doubles, within a given epsilon.

Usage
-----

    import ch.unige.epsilord._
  
    val o = doubleOrdering(0.01)
    import o._

    println( 2.0 *<=* 2.005 ) //Prints 'true'