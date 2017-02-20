import com.typesafe.config._

val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

name := "msp"

version := "1.0"

lazy val `msp` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc ,
  cache ,
  ws   ,
  javaWs,
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "junit" % "junit" % "4.11",
  "com.github.alaisi.pgasync"%"postgres-async-driver"%"0.9",
  "com.ning" % "async-http-client" % "1.9.3",
  "javax.inject" % "javax.inject" % "1",
  "pl.matisoft" %% "swagger-play24" % "1.4",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.flywaydb" % "flyway-core" % "3.2.1",
  "com.sun.xml.ws" % "jaxws-rt" % "2.2.10",
   "com.googlecode.libphonenumber" % "libphonenumber" % "7.4.2",
  "com.google.inject.extensions" % "guice-multibindings" % "4.0-beta4")

libraryDependencies += filters

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

flywayUrl :=conf.getString("flywayUrl")

flywayUser :=conf.getString("database.username")

flywayPassword:=conf.getString("database.password")

flywayLocations := Seq(conf.getString("flywayLocations"))

flywaySchemas := Seq(conf.getString("database.schema"))

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v", "--ignore-runners=org.junit.runners.Suite")