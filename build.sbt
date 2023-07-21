
import sbtassembly.AssemblyPlugin.assemblySettings
Seq(assemblySettings: _*)

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala-cron-parser"
  )

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.16"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % "test"

libraryDependencies += "com.monovore" %% "decline" % "2.4.1"