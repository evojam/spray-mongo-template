package com.evojam.app.service.mongo

import com.evojam.mongodb.spray.config.module.MongoModule
import com.typesafe.config.ConfigFactory
import net.codingwell.scalaguice.ScalaModule

object MongoServiceModule extends ScalaModule {

  lazy val config = ConfigFactory.load()

  override def configure() = {
    install(new MongoModule(config))
  }

}
