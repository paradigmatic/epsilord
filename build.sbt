organization := "ch.unige"

name := "epsilord"

version := "0.0.1"

scalaVersion := "2.12.3"

//crossScalaVersions := Seq("2.9.0-1", "2.9.1", "2.9.2" )

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test"
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:existentials")

scalaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"
