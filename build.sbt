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
  specs2 % Test,
  "com.github.alaisi.pgasync"%"postgres-async-driver"%"0.7",
  "com.ning" % "async-http-client" % "1.9.3",
  "javax.inject" % "javax.inject" % "1",
  "pl.matisoft" %% "swagger-play24" % "1.4",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.flywaydb" % "flyway-core" % "3.2.1",
  "com.sun.xml.ws" % "jaxws-rt" % "2.2.10",
  "wsdl4j" % "wsdl4j" % "1.6.3",
  "axis" % "axis-wsdl4j" % "1.5.1",
  "org.apache.axis" % "axis" % "1.4",
  "org.glassfish" % "javax.xml.rpc" % "10.0-b28"
)

libraryDependencies += filters

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

seq(flywaySettings: _*)

flywayUrl :=conf.getString("flywayUrl")

flywayUser :=conf.getString("database.username")

flywayPassword:=conf.getString("database.password")

flywayLocations := Seq(conf.getString("flywayLocations"))

flywaySchemas := Seq(conf.getString("database.schema"))