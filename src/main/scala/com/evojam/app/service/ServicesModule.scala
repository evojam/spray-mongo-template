package com.evojam.app.service

import com.evojam.app.service.mongo.{MongoService, MongoServiceImpl}
import net.codingwell.scalaguice.ScalaModule

object ServicesModule extends ScalaModule {

  override def configure() =
    bind[MongoService].to[MongoServiceImpl]

}
