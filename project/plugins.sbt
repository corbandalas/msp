logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Flyway" at "http://flywaydb.org/repo"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.2")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "3.2.1")