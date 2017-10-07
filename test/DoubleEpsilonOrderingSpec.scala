package ch.unige.epsilord

import org.scalatest.FreeSpec
import org.scalatest.Matchers
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

class DoubleEpsilonOrderingSpec
  extends FreeSpec
    with Matchers
    with GeneratorDrivenPropertyChecks {

  "Within an epsilon " - {

    val eps = 0.01
    val order = doubleOrdering(eps)
    val smallDouble = Gen.choose(0, eps)
    val bigDouble = Gen.choose(-1e-20, 1e20)
    val twiceSmallDouble = for (d <- smallDouble) yield (2 * d)

    import order._

    "I can compute equality" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          ((a + b) *==* a) should be(true)
          ((2.01 * a + b) *==* a) should be(false)
        }
      }
    }

    "I can compute inequality" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          ((a + b) *!=* a) should be(false)
          ((2.01 * a + b) *!=* a) should be(true)
        }
      }
    }

    "I can compute 'lt'" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          (a *<* (a + b)) should be(false)
          (a *<* (2.01 * a + b)) should be(true)
        }
      }
    }

    "I can compute 'gt'" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          ((a + b) *>* a) should be(false)
          ((2.01 * a + b) *>* a) should be(true)
        }
      }
    }


    "I can compute 'gteq'" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          ((a + b) *>=* a) should be(true)
          ((2.01 * a + b) *>=* a) should be(true)
        }
      }
    }

    "I can compute 'lteq'" in {
      forAll(bigDouble, smallDouble) {
        (a: Double, b: Double) => {
          (a *<=* (a + b)) should be(true)
          (a *<=* (2.01 * a + b)) should be(true)
        }
      }
    }

    "I can truncate a double" in {
      forAll(twiceSmallDouble, twiceSmallDouble) {
        (a: Double, b: Double) => {
          whenever(a.truncate == b.truncate) {
            (a *==* b) should be(true)
          }
        }
      }
    }
  }
}
