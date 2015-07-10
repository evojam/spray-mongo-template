name := "spray-mongo-template"

version := "0.1.0-SNAPSHOT"

organization := "com.evojam"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Ywarn-adapted-args",
  "-Ywarn-value-discard",
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code"
)

resolvers ++= Seq(
  Resolver.defaultLocal,
  Resolver.sbtPluginRepo("snapshots"),
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeIvyRepo("releases")
)

val akkaV = "2.3.7"
val sprayV = "1.3.2"

libraryDependencies ++= Seq(
  "com.evojam" %% "spray-mongodb-driver" % "0.1.1-SNAPSHOT",
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe" % "config" % "1.2.1",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "io.spray" %% "spray-can" % sprayV,
  "io.spray" %% "spray-client" % sprayV,
  "io.spray" %% "spray-json" % "1.3.1",
  "io.spray" %% "spray-routing" % sprayV,
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5")
