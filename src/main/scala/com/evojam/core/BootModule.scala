package com.evojam.core

import com.evojam.app.controllers.ControllerModule
import com.evojam.app.service.ServicesModule
import com.evojam.app.service.mongo.MongoServiceModule
import com.evojam.core.akka.AkkaModule
import com.evojam.core.config.ConfigProvider
import com.evojam.core.server.RestModule
import net.codingwell.scalaguice.ScalaModule

class BootModule extends ScalaModule {

  override def configure() {
    install(ConfigProvider)
    install(AkkaModule)
    install(ServicesModule)
    install(MongoServiceModule)
    install(RestModule)
    install(ControllerModule)
  }

}
