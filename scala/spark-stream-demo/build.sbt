name := "spark-streaming-example"

version := "1.0"

scalaVersion := "2.11.12"

//libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "2.4.4" % "provided",
	"org.apache.spark" %% "spark-streaming" % "2.4.4" % "provided"
)
