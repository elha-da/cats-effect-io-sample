import sbt.Resolver

name := "cats-effect-io-sample"

version := "0.1"

scalaVersion := "2.12.4"

resolvers ++= Seq(
  Resolver.bintrayRepo("akka", "maven"),
  "Clever Cloud Bintray" at "https://dl.bintray.com/clevercloud/maven"
)

libraryDependencies += "org.typelevel" %% "cats-effect" % "0.9"

libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.4.0"

libraryDependencies += "com.clevercloud" %% "warp10-scala-client" % "2.0.2"