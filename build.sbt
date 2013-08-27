name := "ADAL"

version := "1.0"

scalaVersion := "2.10.1"

//sbt.version=0.12.0

// set the main Scala source directory to be <base>/src
scalaSource in Compile <<= baseDirectory(_ / "src")

// set the Scala test source directory to be <base>/test
scalaSource in Test <<= baseDirectory(_ / "test")

// add a test dependency on ScalaCheck
libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "1.9.1" % "test",
	"org.specs2" %% "specs2" % "2.1.1" % "test"
)

libraryDependencies += "junit" % "junit" % "4.11" % "test"
