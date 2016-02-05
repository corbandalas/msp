name := "msp"

version := "1.0"

lazy val `msp` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc ,
  cache ,
  ws   ,
  specs2 % Test,
  "com.github.alaisi.pgasync"%"postgres-async-driver"%"0.7",
  "com.ning" % "async-http-client" % "1.9.3",
  "javax.inject" % "javax.inject" % "1",
  "pl.matisoft" %% "swagger-play24" % "1.4",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)

libraryDependencies += filters

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

seq(flywaySettings: _*)

flywayUrl := "jdbc:postgresql://localhost:5432/msp_db"

flywayUser := "msp_db"

flywayPassword:="x13jkw34"

flywayLocations := Seq("filesystem:db")

flywaySchemas := Seq("msp_scheme")