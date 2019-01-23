name := "janusGraphTemplate"

version := "0.1"

scalaVersion := "2.11.11"

val janusGraphVersion = "0.3.1"
val hBaseVersion = "2.1.1"
val scalaTest = "2.2.1"
val scalaCheck = "1.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % scalaTest % "test",
  "org.scalacheck" %% "scalacheck" % scalaCheck % "test",
  //"org.apache.hbase" % "hbase-server" % hBaseVersion % "test" classifier "tests",
  //"org.apache.hbase" % "hbase-common" % hBaseVersion % "test" classifier "tests",
  "org.apache.hbase" % "hbase-testing-util" % hBaseVersion % "test" classifier "tests",
  "org.janusgraph" % "janusgraph-core" % janusGraphVersion % "test")


