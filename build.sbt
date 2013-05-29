name := "ADAL"

version := "1.0"

scalaVersion := "2.10.1"

//sbt.version=0.12.0

// set the main Scala source directory to be <base>/src
scalaSource in Compile <<= baseDirectory(_ / "adalDSL/src")

// set the Scala test source directory to be <base>/test
scalaSource in Test <<= baseDirectory(_ / "adalDSL/test")

// add a test dependency on ScalaCheck
libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

libraryDependencies += "junit" % "junit" % "4.11" % "test"