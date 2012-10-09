organization := "ch.unige"

name := "epsilord"

version := "0.0.1"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.0-1", "2.9.1", "2.9.2" )

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"

scalacOptions += "-deprecation"

scalaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

