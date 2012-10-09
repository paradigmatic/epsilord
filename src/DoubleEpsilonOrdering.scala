package ch.unige.epsilord

case class DoubleEpsilonOrdering( epsilon: Double ) extends Ordering[Double] {

  def compare( x: Double, y: Double ): Int = {
    if( x + epsilon < y ) -1
    else if( x - epsilon > y ) 1
    else 0
  }

  implicit def mkOps( x: Double ) = new Ops(x)
  
  class Ops( x: Double ) {
    def *==*( y: Double ) = equiv(x,y)
    def *!=*( y: Double ) = ! equiv(x,y)
    def *>*( y: Double ) = gt(x,y)
    def *>=*( y: Double ) = gteq(x,y)
    def *<*( y: Double ) = lt(x,y)
    def *<=*( y: Double ) = lteq(x,y)
  }


}
