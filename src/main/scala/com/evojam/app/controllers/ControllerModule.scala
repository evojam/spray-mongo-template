package com.evojam.app.controllers

import com.evojam.core.server.RouteComponent
import net.codingwell.scalaguice._

object ControllerModule extends ScalaModule {

  private lazy val componentBinder = ScalaMultibinder.newSetBinder[RouteComponent](binder)

  def bindComponent() = componentBinder.addBinding

  override def configure() = {
    bindComponent().to[MongoController]
  }

}
