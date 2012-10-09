package ch.unige.epsilord

import org.scalatest.FreeSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

class DoubleEpsilonOrderingSpec 
extends FreeSpec 
with ShouldMatchers 
with GeneratorDrivenPropertyChecks {

  "Within an epsilon " -{

    val eps = 0.01
    val order = doubleOrdering(eps)
    val smallDouble = Gen.choose(0,eps)
    val bigDouble = Gen.choose(-1e-20,1e20)
    import order._

    "I can compute equality" in {
      forAll( bigDouble, smallDouble ){ 
	(a:Double,b:Double) => {
	  ( (a+b) *==* a ) should be (true)
	  ( (2.01*a+b) *==* a ) should be (false)
	}
      }
    }

    "I can compute inequality" in {
      forAll( bigDouble, smallDouble ){ 
	(a:Double,b:Double) => {
	  ( (a+b) *!=* a ) should be (false)
	  ( (2.01*a+b) *!=* a ) should be (true)
	}
      }
    }

    "I can compute 'lt'" in {
      forAll( bigDouble, smallDouble ){ 
	(a:Double,b:Double) => {
	  ( a *<* (a+b) ) should be (false)
	  ( a *<* (2.01*a+b) ) should be (true)
	}
      }
    }

    "I can compute 'gt'" in {
      forAll( bigDouble, smallDouble ){ 
	(a:Double,b:Double) => {
	  ( (a+b) *>* a ) should be (false)
	  ( (2.01*a+b) *>* a ) should be (true)
	}
      }
    }

/*

    "I can compute 'gteq'" in {
      forAll( bigDouble, smallDouble ){ 
	(a:Double,b:Double) => {
	  ( (a+b) *>=* a ) should be (true)
	  ( (a+b+eps) *>=* a ) should be (true)
	  ( (2.01*a+b) *>* a ) should be (true)
	}
      }
    }
*/

  }

}
