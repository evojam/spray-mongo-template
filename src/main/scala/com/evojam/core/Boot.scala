package com.evojam.core

import com.evojam.core.server.Server
import com.google.inject.Guice

object Boot extends App {

  val injector = Guice.createInjector(new BootModule)

  injector.getInstance(classOf[Server]).start()
}
